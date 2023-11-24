import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
class Contact{
    private final String FName;
    private final String LName;
    private String Number;
    private String Email;
    public Contact(String FName, String LName, String number, String email) {
        this.FName = FName;
        this.LName = LName;
        this.Number = number;
        this.Email = email;
    }
    public String getFName() {
        return FName;
    }
    public String getLName() {
        return LName;
    }
    public String getNumber() {
        return Number;
    }
    public void setNumber(String number) {
        Number = number;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String toString() {
        return "Contact{" +
                "FName='" + FName + '\'' +
                ", LName='" + LName + '\'' +
                ", Number='" + Number + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}class Contacts {
    HashSet<Contact> contacts;
    public Contacts() {
        this.contacts = new HashSet<>();
    }
    public void addContact(String FName, String LName, String number, String email, FileWriter writer) {
        if (contacts.stream().anyMatch(c -> c.getNumber().equals(number))) {
            writeToFile("Found a contact with the same Number", writer);
        } else {
            contacts.add(new Contact(FName, LName, number, email));
            writeToFile("One Contact Added!", writer);
            writeContactToFile(FName, LName, number, email, writer);
        }
    }
    public void updateContactNumber(String fName, String number, FileWriter writer) {
        contacts.stream()
                .filter(c -> c.getFName().equals(fName))
                .findFirst()
                .ifPresentOrElse(
                        contact -> {
                            contact.setNumber(number);
                            writeToFile("Contact Number Updated", writer);
                            writeContactToFile(contact, writer);
                        },
                        () -> writeToFile("No Such Contact Found", writer)
                );
    }
    public void updateContactEmail(String fName, String email, FileWriter writer) {
        contacts.stream()
                .filter(c -> c.getFName().equals(fName))
                .findFirst()
                .ifPresentOrElse(
                        contact -> {
                            contact.setEmail(email);
                            writeToFile("Contact Email Updated", writer);
                            writeContactToFile(contact, writer);
                        },
                        () -> writeToFile("No Such Contact Found", writer)
                );
    }
    public void deleteContact(String fName, String lName, FileWriter writer) {
        contacts.removeIf(c -> (c.getFName().equals(fName) && c.getLName().equals(lName)));
        writeToFile("Contact Deleted", writer);
        listContacts(writer);
    }
    public void getContact(String fName, String lName, FileWriter writer) {
        List<Contact> list = contacts.stream()
                .filter(c -> (c.getFName().equals(fName) && c.getLName().equals(lName)))
                .toList();
        if (!list.isEmpty()) {
            list.forEach(contact -> writeContactToFile(contact, writer));
        } else {
            writeToFile("No Such Contact Found", writer);
        }
    }
    public void listContacts(FileWriter writer) {
        contacts.forEach(contact -> writeContactToFile(contact, writer));
    }

    private void writeContactToFile(String FName, String LName, String number, String email, FileWriter writer) {
        writeToFile(String.format("%s,%s,%s,%s", FName, LName, number, email), writer);
    }
    private void writeContactToFile(Contact contact, FileWriter writer) {
        writeToFile(contact.toString(), writer);
    }
    private void writeToFile(String message, FileWriter writer) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }
}
public class ContactInformation {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String path = "F:\\TestCase123.txt";
        File f = new File(path);
        try (FileWriter writer = new FileWriter(f, true)) {
            Contacts contactsManager = new Contacts();
            while (true) {
                System.out.println("""
                        1.Add Contact
                        2.Update ContactNumber
                        3.Update ContactEmail
                        4.Delete Contact
                        5.Find Contact
                        6.Display Contacts
                        7.Exit""");
                int choice = s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 1: {
                        System.out.print("Enter First Name: ");
                        String fName = s.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lName = s.nextLine();
                        System.out.print("Enter Mobile Number: ");
                        String number = s.nextLine();
                        System.out.print("Enter Email: ");
                        String email = s.nextLine();
                        contactsManager.addContact(fName, lName, number, email, writer);
                    }
                    break;
                    case 2: { System.out.print("Enter First Name: ");
                        String fName = s.nextLine();
                        System.out.print("Enter New Number: ");
                        String newNumber = s.nextLine();
                        contactsManager.updateContactNumber(fName,newNumber,writer);
                    }break;
                    case 3:{
                        System.out.print("Enter First Name: ");
                        String fName = s.nextLine();
                        System.out.print("Enter New Mail Id: ");
                        String newMail = s.nextLine();
                        contactsManager.updateContactEmail(fName,newMail,writer);
                    }break;
                    case 4:{
                        System.out.print("Enter First Name: ");
                        String fName = s.nextLine();
                        System.out.print("Enter Last Name: ");
                        String LName = s.nextLine();
                        contactsManager.getContact(fName,LName,writer);
                    }break;
                    case 5:{
                        System.out.print("Enter First Name: ");
                        String fName = s.nextLine();
                        System.out.print("Enter Last Name: ");
                        String LName = s.nextLine();
                        contactsManager.deleteContact(fName,LName,writer);
                    }
                    case 6: {
                        contactsManager.listContacts(writer);
                    }break;
                    case 7:{
                        System.exit(0);
                    }break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        }
    }
}
