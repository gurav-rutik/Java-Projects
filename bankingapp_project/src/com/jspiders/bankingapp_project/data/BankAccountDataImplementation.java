package com.jspiders.bankingapp_project.data;

import java.util.ArrayList;
import java.util.List;
import com.jspiders.bankingapp_project.entity.BankAccount;
import com.jspiders.bankingapp_project.entity.User;

public class BankAccountDataImplementation implements BankAccountData {

    private List<BankAccount> bankAccounts = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    @Override
    public boolean addBankAccount(BankAccount bankAccount) {
        if (bankAccount != null && findBankAccountByNumber(bankAccount.getAccountNumber()) == null) {
            bankAccounts.add(bankAccount);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBankAccount(long accountNumber, int userId) { // Change parameter back to int userId
        BankAccount account = findBankAccountByNumber(accountNumber);
        User user = findUserById(userId); // Find user by userId instead of mobile number
        if (account != null && user != null) {
            bankAccounts.remove(account);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(long accountNumber, double amount) {
        BankAccount account = findBankAccountByNumber(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        System.out.println("Account not found.");
        return false;
    }

    @Override
    public boolean withdraw(long accountNumber, double amount) {
        BankAccount account = findBankAccountByNumber(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            return true;
        }
        System.out.println("Account not found.");
        return false;
    }

    @Override
    public Double getBalance(long accountNumber) {
        BankAccount account = findBankAccountByNumber(accountNumber);
        return account != null ? account.getAccountBalance() : null;
    }

    public User findUserByMobileNumber(long mobileNumber) {
        for (User user : users) {
            if (user.getMobileNumber() == mobileNumber) {
                return user;
            }
        }
        return null;
    }

    // Helper method to find a bank account by account number
    private BankAccount findBankAccountByNumber(long accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Method to add users to the list for testing or other purposes
    public void addUser(User user) {
        if (user != null && findUserByMobileNumber(user.getMobileNumber()) == null) {
            users.add(user);
        }
    }

    @Override
    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getSecurityPin() == userId) { // Use securityPin to find user
                return user;
            }
        }
        return null; // Return null if not found
    }
}
