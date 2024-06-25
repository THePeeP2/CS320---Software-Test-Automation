import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointments;

    // Constructor initializes the in-memory data structure for storing appointments
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // Method to add a new appointment
    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getId())) {
            throw new IllegalArgumentException("Invalid appointment or appointment ID already exists");
        }
        appointments.put(appointment.getId(), appointment);
    }

    // Method to delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        appointments.remove(appointmentId);
    }

    // Method to retrieve an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        return appointments.get(appointmentId);
    }
}
