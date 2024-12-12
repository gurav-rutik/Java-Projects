package com.jspiders.bankingapp_project;

import java.util.Scanner;

import com.jspiders.bankingapp_project.business.BankAccountBusiness;
import com.jspiders.bankingapp_project.business.BankAccountBusinessImplementation; 
import com.jspiders.bankingapp_project.business.UserBusiness;
import com.jspiders.bankingapp_project.business.UserBusinessImplementation;

public class App2 {
    public static void main(String[] args) {

        BankAccountBusiness bankAccountBusiness = new BankAccountBusinessImplementation(); 

        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\n--- Banking Application ---");
            System.out.println("Enter 1 to create a bank account");
            System.out.println("Enter 2 to deposit");
            System.out.println("Enter 3 to withdraw");
            System.out.println("Enter 4 to check account balance");
            System.out.println("Enter 5 to delete a bank account");
            System.out.println("Enter 6 to exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bankAccountBusiness.createBankAccount();
                    break;
                case 2:
                    bankAccountBusiness.deposit();
                    break;
                case 3:
                    bankAccountBusiness.withdraw();
                    break;
                case 4:
                    bankAccountBusiness.checkAccountBalance();
                    break;
                case 5:
                    bankAccountBusiness.deleteBankAccount();
                    break; 
                case 6:
                    run = false;
                    System.out.println("Thank you for using the banking application!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
