package com.atm;



public class Transaction {
    private String type;
    private double amount;
    private String recipient;

    public Transaction(String type, double amount, String recipient) {
        this.type = type;
        this.amount = amount;
        this.recipient = recipient;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getRecipient() {
        return recipient;
    }
}
