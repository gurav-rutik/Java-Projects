package com.jspiders.contactmanagerproject;


import java.util.Scanner;
import com.jspiders.contactmanagerproject.entity.Contact;
import com.jspiders.contactmanagerproject.business.Business;
import com.jspiders.contactmanagerproject.business.BusinessImplementation;

public class AppMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Business business = new BusinessImplementation();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Find Contact by ID");
            System.out.println("4. View All Contacts");
            System.out.println("5. Update Contact");  // New option
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact(scanner, business);
                    break;
                case 2:
                    deleteContact(scanner, business);
                    break;
                case 3:
                    findContactById(scanner, business);
                    break;
                case 4:
                    viewAllContacts(business);
                    break;
                case 5:
                    updateContact(scanner, business);  // Update contact case
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addContact(Scanner scanner, Business business) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.next();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.next();
        System.out.print("Enter Mobile: ");
        long mobile = scanner.nextLong();
        System.out.print("Enter Work Phone: ");
        long work = scanner.nextLong();
        System.out.print("Enter Email: ");
        String email = scanner.next();

        Contact contact = new Contact(0, firstName, lastName, mobile, work, email);
        business.addContact(contact);
    }

    private static void deleteContact(Scanner scanner, Business business) {
        System.out.print("Enter Contact ID to delete: ");
        int id = scanner.nextInt();
        business.deleteContact(id);
    }

    private static void findContactById(Scanner scanner, Business business) {
        System.out.print("Enter Contact ID: ");
        int id = scanner.nextInt();
        Contact contact = business.findContactById(id);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact not found");
        }
    }

    private static void viewAllContacts(Business business) {
        Contact[] contacts = business.findAllContacts();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void updateContact(Scanner scanner, Business business) {
        System.out.print("Enter Contact ID to update: ");
        int id = scanner.nextInt();
        Contact existingContact = business.findContactById(id);
        if (existingContact != null) {
            System.out.print("Enter new First Name: ");
            String firstName = scanner.next();
            System.out.print("Enter new Last Name: ");
            String lastName = scanner.next();
            System.out.print("Enter new Mobile: ");
            long mobile = scanner.nextLong();
            System.out.print("Enter new Work Phone: ");
            long work = scanner.nextLong();
            System.out.print("Enter new Email: ");
            String email = scanner.next();

            Contact updatedContact = new Contact(id, firstName, lastName, mobile, work, email);
            business.updateContact(updatedContact);
        } else {
            System.out.println("Contact not found");
        }
    }
}

/*
 * com.jspiders.contactmanager
│
├── business
│   ├── Business.java                 // Interface for business logic.
│   ├── BusinessImplementation.java   // Business logic with Hibernate integration.
│
├── data
│   ├── HibernateUtil.java            // Utility class for Hibernate session factory.
│
├── entity
│   ├── Contact.java                  // Entity class with Hibernate annotations.
│
├── resources
│   ├── persistence.xml               // Persistence configuration file for JPA.
│
└── AppMain.java                      // Main application class for user interaction.

 * */


