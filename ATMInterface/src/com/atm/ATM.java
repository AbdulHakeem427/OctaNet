package com.atm;

import java.util.ArrayList;

public class ATM {
    private double initialBalance;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public ATM() {
        this.initialBalance = 100000;
        this.balance = this.initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String deposit(double amount) {
        this.balance += amount;
        Transaction transaction = new Transaction("Deposit", amount, null);
        this.transactionHistory.add(transaction);
        return "Deposited $" + amount + ". New balance: $" + this.balance;
    }

    public String withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            Transaction transaction = new Transaction("Withdrawal", amount, null);
            this.transactionHistory.add(transaction);
            return "Withdrawn $" + amount + ". New balance: $" + this.balance;
        } else {
            return "Insufficient funds";
        }
    }

    public String transfer(double amount, String recipient) {
        if (amount <= this.balance) {
            this.balance -= amount;
            Transaction transaction = new Transaction("Transfer", amount, recipient);
            this.transactionHistory.add(transaction);
            return "Transferred $" + amount + " to " + recipient + ". New balance: $" + this.balance;
        } else {
            return "Insufficient funds";
        }
    }

    public String getBalance() {
        return "Current balance: $" + this.balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }
}
