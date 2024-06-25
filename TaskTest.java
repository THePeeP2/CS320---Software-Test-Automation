import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "Task 1", "Description of Task 1");
        assertEquals("1", task.getTaskId());
        assertEquals("Task 1", task.getName());
        assertEquals("Description of Task 1", task.getDescription());
    }

    @Test
    public void testTaskNameUpdate() {
        Task task = new Task("1", "Task 1", "Description of Task 1");
        task.setName("Updated Task 1");
        assertEquals("Updated Task 1", task.getName());
    }

    @Test
    public void testTaskDescriptionUpdate() {
        Task task = new Task("1", "Task 1", "Description of Task 1");
        task.setDescription("Updated description");
        assertEquals("Updated description", task.getDescription());
    }

    @Test
    public void testTaskNullFields() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task", null));
    }

    @Test
    public void testTaskMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "123456789012345678901", "Description"));
    }
}
