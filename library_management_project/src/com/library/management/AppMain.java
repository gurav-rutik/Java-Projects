package com.library.management;

import java.util.Scanner;

import com.library.management.business.LibraryBusiness;
import com.library.management.business.LibraryBusinessImplementation;

public class AppMain {

    private static LibraryBusiness business = new LibraryBusinessImplementation();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean run = true;

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("          LIBRARY MENU                 ");
        System.out.println("=======================================");

        while (run) {
            System.out.println("1. ADD BOOK");
            System.out.println("2. UPDATE BOOK");
            System.out.println("3. DELETE BOOK");
            System.out.println("4. RESTORE BOOK");
            System.out.println("5. SEARCH BY TITLE");
            System.out.println("6. SEARCH BY AUTHOR");
            System.out.println("7. SEARCH BY GENRE");
            System.out.println("8. BORROW BOOK");
            System.out.println("9. RETURN BOOK");
            System.out.println("10. SHOW ALL BOOKS");
            System.out.println("11. EXIT");
            System.out.println("=======================================");
            System.out.print("ENTER YOUR CHOICE: \n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    business.addBook();
                    break;
                case 2:
                    business.updateBook();
                    break;
                case 3:
                    business.deleteBook();
                    break;
                case 4:
                    business.restoreBook();
                    break;
                case 5:
                    business.searchByTitle();
                    break;
                case 6:
                    business.searchByAuthor();
                    break;
                case 7:
                    business.searchByGenre();
                    break;
                case 8:
                    business.borrowBook();
                    break;
                case 9:
                    business.returnBook();
                    break;
                case 10:
                    business.showAllBooks();  // Call the new method
                    break;
                case 11:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
