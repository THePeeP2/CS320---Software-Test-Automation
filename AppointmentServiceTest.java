import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        String name = "Meeting";
        String id = "12345";
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        String description = "Project discussion";
        Appointment appointment = new Appointment(name, id, futureDate, description);

        appointmentService.addAppointment(appointment);

        // Assert that the appointment was added successfully
        assertEquals(appointment, appointmentService.getAppointment(id));
    }

    @Test
    public void testAddDuplicateAppointment() {
        String name = "Meeting";
        String id = "12345";
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        String description = "Project discussion";
        Appointment appointment1 = new Appointment(name, id, futureDate, description);

        appointmentService.addAppointment(appointment1);

        Appointment appointment2 = new Appointment(name, id, futureDate, description);

        // Assert that adding a duplicate appointment throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        String name = "Meeting";
        String id = "12345";
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        String description = "Project discussion";
        Appointment appointment = new Appointment(name, id, futureDate, description);

        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment(id);

        // Assert that the appointment was deleted successfully
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.getAppointment(id);
        });
    }

    @Test
    public void testDeleteNonexistentAppointment() {
        String nonexistentId = "54321";

        // Assert that deleting a nonexistent appointment throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment(nonexistentId);
        });
    }
}
