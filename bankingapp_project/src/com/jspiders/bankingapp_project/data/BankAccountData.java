package com.jspiders.bankingapp_project.data;

import com.jspiders.bankingapp_project.entity.BankAccount;
import com.jspiders.bankingapp_project.entity.User;

public interface BankAccountData {
    boolean addBankAccount(BankAccount bankAccount);
    
    boolean deleteBankAccount(long accountNumber, int userId);
    
    boolean deposit(long accountNumber, double amount);
    
    boolean withdraw(long accountNumber, double amount);
    
    Double getBalance(long accountNumber); // Updated to Double to handle null cases

    User findUserById(int userId); // Consider moving to a separate UserData interface if necessary
}
