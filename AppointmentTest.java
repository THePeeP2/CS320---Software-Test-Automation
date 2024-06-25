import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    @Test
    public void testAppointmentCreation() {
        String name = "Meeting";
        String id = "12345";
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        String description = "Project discussion";

        Appointment appointment = new Appointment(name, id, futureDate, description);

        // Assert statements to verify that the appointment was created with the correct values
        assertEquals(name, appointment.getName());
        assertEquals(id, appointment.getId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals(description, appointment.getDescription());
    }

    @Test
    public void testInvalidName() {
        String invalidName = null;
        String id = "12345";
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        String description = "Project discussion";

        // Assert that an IllegalArgumentException is thrown for invalid name
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(invalidName, id, futureDate, description);
        });
    }

    @Test
    public void testInvalidId() {
        String name = "Meeting";
        String invalidId = null;
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        String description = "Project discussion";

        // Assert that an IllegalArgumentException is thrown for invalid ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(name, invalidId, futureDate, description);
        });
    }

    @Test
    public void testInvalidDate() {
        String name = "Meeting";
        String id = "12345";
        Date pastDate = new Date(System.currentTimeMillis() - 100000); // Past date
        String description = "Project discussion";

        // Assert that an IllegalArgumentException is thrown for past date
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(name, id, pastDate, description);
        });
    }

    @Test
    public void testInvalidDescription() {
        String name = "Meeting";
        String id = "12345";
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        String invalidDescription = null;

        // Assert that an IllegalArgumentException is thrown for invalid description
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(name, id, futureDate, invalidDescription);
        });
    }
}
