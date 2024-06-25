import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertEquals(1, contactService.getContactsCount());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.deleteContact("C001");
        assertEquals(0, contactService.getContactsCount());
    }

    @Test
    public void testUpdateContactFirstName() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactFirstName("C001", "Jane");
        assertEquals("Jane", contactService.getContact("C001").getFirstName());
    }

    @Test
    public void testUpdateContactLastName() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactLastName("C001", "Smith");
        assertEquals("Smith", contactService.getContact("C001").getLastName());
    }

    @Test
    public void testUpdateContactPhone() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactPhone("C001", "9876543210");
        assertEquals("9876543210", contactService.getContact("C001").getPhone());
    }

    @Test
    public void testUpdateContactAddress() {
        Contact contact = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactAddress("C001", "456 Broad St");
        assertEquals("456 Broad St", contactService.getContact("C001").getAddress());
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("C001", "Jane", "Smith", "9876543210", "456 Broad St");

        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("C001");
        });
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFirstName("C001", "Jane");
        });
    }
}
