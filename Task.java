public class Task {
    private final String taskId;
    private String name;
    private String description;

    // Constructor to initialize the Task object
    public Task(String taskId, String name, String description) {
        // Validate the task ID
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }

        // Validate the name
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }

        // Validate the description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        // Assign the validated values to the fields
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getter for task ID
    public String getTaskId() {
        return taskId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
