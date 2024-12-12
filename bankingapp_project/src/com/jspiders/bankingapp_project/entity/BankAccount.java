package com.jspiders.bankingapp_project.entity;

public class BankAccount {
    private String bankName;
    private long accountNumber;
    private double accountBalance;


    public BankAccount() {
        super();
    }

    public BankAccount(String bankName, long accountNumber, double accountBalance) {
        super();
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            return true;
        } else {
            System.out.println("Enter a valid amount");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            return true;
        } else if (amount <= 0) {
            System.out.println("Enter a valid withdrawal amount");
        } else {
            System.out.println("Insufficient account balance");
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount [bankName=" + bankName + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
    }
}
