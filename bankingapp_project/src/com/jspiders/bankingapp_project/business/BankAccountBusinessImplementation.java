package com.jspiders.bankingapp_project.business;

import java.util.Scanner;
import com.jspiders.bankingapp_project.data.BankAccountDataImplementation;
import com.jspiders.bankingapp_project.entity.BankAccount;


public class BankAccountBusinessImplementation implements BankAccountBusiness {

    private BankAccountDataImplementation bankAccountData = new BankAccountDataImplementation();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void createBankAccount() {
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();

        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        BankAccount bankAccount = new BankAccount(bankName, accountNumber, initialDeposit);
        if (bankAccountData.addBankAccount(bankAccount)) {
            System.out.println("Bank account created successfully!");
        } else {
            System.out.println("Failed to create bank account. Account number might already exist.");
        }
    }

    @Override
    public void deleteBankAccount() {
        System.out.print("Enter account number to delete: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter your user ID: ");  // Ask for user ID instead of mobile number
        int userId = scanner.nextInt(); // Changed from mobileNumber to userId

        if (bankAccountData.deleteBankAccount(accountNumber, userId)) { // Pass userId
            System.out.println("Bank account deleted successfully!");
        } else {
            System.out.println("Failed to delete bank account. Check account number or user ID.");
        }
    }

    @Override
    public void deposit() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        if (bankAccountData.deposit(accountNumber, amount)) {
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Failed to deposit amount. Check account number.");
        }
    }

    @Override
    public void withdraw() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        if (bankAccountData.withdraw(accountNumber, amount)) {
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Failed to withdraw amount. Check account number or account balance.");
        }
    }

    @Override
    public void checkAccountBalance() {
        System.out.print("Enter account number: ");
        long accountNumber = scanner.nextLong();

        Double balance = bankAccountData.getBalance(accountNumber);
        if (balance != null) {
            System.out.println("Current account balance: " + balance);
        } else {
            System.out.println("Account not found.");
        }
    }
}
