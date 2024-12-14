package com.jspiders.contactmanager;

import java.util.Scanner;
import com.jspiders.contactmanager.business.Business;
import com.jspiders.contactmanager.business.BusinessImplementation;

public class AppMain {

    private static Business business = new BusinessImplementation();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean run = true;

    public static void main(String[] args) {
        while (run) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    business.addContact();
                    break;
                case 2:
                    business.deleteContact();
                    break;
                case 3:
                    business.updateContact();
                    break;
                case 4:
                    business.findContactByFirstName();
                    break;
                case 5:
                    business.findContactByLastName();
                    break;
                case 6:
                    business.findAllContacts();
                    break;
                case 7:
                    business.search();
                    break;
                case 8:
                    System.out.println("See you soon!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close(); 
    }

    private static void displayMenu() {
        System.out.println("=======================================");
        System.out.println("          CONTACT MANAGER APP        ");
        System.out.println("=======================================");
        System.out.println("1. ADD CONTACT");
        System.out.println("2. DELETE CONTACT");
        System.out.println("3. UPDATE CONTACT");
        System.out.println("4. FIND CONTACT BY FIRST NAME");
        System.out.println("5. FIND CONTACT BY LAST NAME");
        System.out.println("6. FIND ALL CONTACTS");
        System.out.println("7. SEARCH CONTACT");
        System.out.println("8. EXIT");
        System.out.println("=======================================");
        System.out.print("ENTER YOUR CHOICE: ");
    }
}
