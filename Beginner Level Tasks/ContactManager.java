import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Contact Management System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> updateContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Exiting... Bye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("✅ Contact added!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("⚠️ No contacts found.");
            return;
        }
        System.out.println("\n--- Contact List ---");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void updateContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to update: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index < 0 || index >= contacts.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }

        Contact c = contacts.get(index);
        System.out.print("Enter new name (" + c.getName() + "): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) c.setName(name);

        System.out.print("Enter new phone (" + c.getPhone() + "): ");
        String phone = sc.nextLine();
        if (!phone.isEmpty()) c.setPhone(phone);

        System.out.print("Enter new email (" + c.getEmail() + "): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) c.setEmail(email);

        System.out.println("✅ Contact updated!");
    }

    private static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index < 0 || index >= contacts.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }

        contacts.remove(index);
        System.out.println("✅ Contact deleted!");
    }
}
