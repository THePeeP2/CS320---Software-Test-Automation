import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");

        assertEquals("C001", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactFirstNameMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "Johnnnnnnnnn", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactLastNameRequired() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactPhoneFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "John", "Doe", "123", "123 Main St");
        });
    }

    @Test
    public void testContactAddressMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C001", "John", "Doe", "1234567890", "123 Main St, Apartment 1, Very Long Address");
        });
    }
}
