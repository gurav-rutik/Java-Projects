// AppMain.java
package com.jspiders.student.main;

import com.jspiders.student.business.StudentBusiness;
import com.jspiders.student.business.StudentBusinessImplementation;

import java.util.Scanner;

public class AppMain {

    private static StudentBusiness business = new StudentBusinessImplementation();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean run = true;

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("          STUDENT MANAGEMENT MENU      ");
        System.out.println("=======================================");

        while (run) {
            System.out.println("1. ADD STUDENT");
            System.out.println("2. UPDATE STUDENT");
            System.out.println("3. DELETE STUDENT");
            System.out.println("4. RESTORE STUDENT");
            System.out.println("5. SEARCH BY NAME");
            System.out.println("6. SEARCH BY CLASS");
            System.out.println("7. GRADUATE STUDENT");
            System.out.println("8. MARK AS DROPOUT");
            System.out.println("9. SHOW ALL STUDENTS");
            System.out.println("10. EXIT");
            System.out.println("=======================================");
            System.out.print("ENTER YOUR CHOICE: \n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    business.addStudent();
                    break;
                case 2:
                    business.updateStudent();
                    break;
                case 3:
                    business.deleteStudent();
                    break;
                case 4:
                    business.restoreStudent();
                    break;
                case 5:
                    business.searchByName();
                    break;
                case 6:
                    business.searchByClass();
                    break;
                case 7:
                    business.graduateStudent();
                    break;
                case 8:
                    business.markDropout();
                    break;
                case 9:
                    business.showAllStudents();
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
