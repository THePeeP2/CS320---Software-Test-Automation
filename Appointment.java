import java.util.Date;

public class Appointment {
    private String name;          // The name of the appointment
    private String id;            // The unique ID of the appointment
    private Date appointmentDate; // The date of the appointment
    private String description;   // The description of the appointment

    // Constructor to initialize the Appointment object
    public Appointment(String name, String id, Date appointmentDate, String description) {
        // Validate the name
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException("Invalid name");
        }

        // Validate the id
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid id");
        }

        // Validate the appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }

        // Validate the description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        // Assign the validated values to the fields
        this.name = name;
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Getter for appointment date
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }
}
