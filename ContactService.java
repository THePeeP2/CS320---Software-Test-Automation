import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found for ID: " + contactId);
        }
        contacts.remove(contactId);
    }

    public void updateContactFirstName(String contactId, String firstName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found for ID: " + contactId);
        }
        contacts.get(contactId).setFirstName(firstName);
    }

    public void updateContactLastName(String contactId, String lastName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found for ID: " + contactId);
        }
        contacts.get(contactId).setLastName(lastName);
    }

    public void updateContactPhone(String contactId, String phone) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found for ID: " + contactId);
        }
        contacts.get(contactId).setPhone(phone);
    }

    public void updateContactAddress(String contactId, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found for ID: " + contactId);
        }
        contacts.get(contactId).setAddress(address);
    }

    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found for ID: " + contactId);
        }
        return contacts.get(contactId);
    }

    public int getContactsCount() {
        return contacts.size();
    }
}
