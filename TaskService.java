import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    // Add a task to the service
    public void addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task is null or Task ID already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Delete a task from the service
    public void deleteTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID is null or does not exist");
        }
        tasks.remove(taskId);
    }

    // Update the name of a task
    public void updateTaskName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task does not exist");
        }
        task.setName(newName);
    }

    // Update the description of a task
    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task does not exist");
        }
        task.setDescription(newDescription);
    }

    // Get a task by its ID
    public Task getTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID is null or does not exist");
        }
        return tasks.get(taskId);
    }
}
