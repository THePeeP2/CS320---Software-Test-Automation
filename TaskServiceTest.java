import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
        Task task1 = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task1);
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task("3", "Task 3", "Description of Task 3");
        taskService.addTask(newTask);
        assertEquals(newTask, taskService.getTask("3"));
    }

    @Test
    public void testDeleteTask() {
        taskService.deleteTask("1");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask("1");
        });
    }

    @Test
    public void testUpdateTaskName() {
        taskService.updateTaskName("1", "Updated Task 1");
        assertEquals("Updated Task 1", taskService.getTask("1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        taskService.updateTaskDescription("1", "Updated description");
        assertEquals("Updated description", taskService.getTask("1").getDescription());
    }
}
