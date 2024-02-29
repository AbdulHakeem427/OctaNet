package com.atm;

import java.util.ArrayList;

public class ATMService {
    public static void main(String[] args) {
        ATM atm = new ATM();

        OutputHandler.displayMessage("Welcome to the ATM Interface");

        String userId = InputHandler.getUserInput("Enter User ID: ");
        String pin = InputHandler.getUserInput("Enter PIN: ");

        User user = new User(userId, pin);

        if (user.getUserId().equals("123456") && user.getPin().equals("934755")) {
            OutputHandler.displayMessage("Login successful!\n");

            while (true) {
                OutputHandler.displayMessage("ATM Operations:");
                OutputHandler.displayMessage("1. Deposit");
                OutputHandler.displayMessage("2. Withdraw");
                OutputHandler.displayMessage("3. Transfer");
                OutputHandler.displayMessage("4. Check Balance");
                OutputHandler.displayMessage("5. Transaction History");
                OutputHandler.displayMessage("6. Quit");

                String choice = InputHandler.getUserInput("Enter your choice (1/2/3/4/5/6): ");

                switch (choice) {
                    case "1":
                        double depositAmount = Double.parseDouble(InputHandler.getUserInput("Enter the deposit amount: ₹"));
                        OutputHandler.displayMessage(atm.deposit(depositAmount));
                        break;
                    case "2":
                        double withdrawalAmount = Double.parseDouble(InputHandler.getUserInput("Enter the withdrawal amount: ₹"));
                        OutputHandler.displayMessage(atm.withdraw(withdrawalAmount));
                        break;
                    case "3":
                        double transferAmount = Double.parseDouble(InputHandler.getUserInput("Enter the transfer amount: ₹"));
                        String recipient = InputHandler.getUserInput("Enter the recipient's name: ");
                        OutputHandler.displayMessage(atm.transfer(transferAmount, recipient));
                        break;
                    case "4":
                        OutputHandler.displayMessage(atm.getBalance());
                        break;
                    case "5":
                        ArrayList<Transaction> history = atm.getTransactionHistory();
                        if (!history.isEmpty()) {
                            for (Transaction transaction : history) {
                                OutputHandler.displayMessage(transaction.getType() + " ₹" + transaction.getAmount() + " to " + transaction.getRecipient());
                            }
                        } else {
                            OutputHandler.displayMessage("Transaction history is empty.");
                        }
                        break;
                    case "6":
                        OutputHandler.displayMessage("Thank you for using ATM. Goodbye!");
                        System.exit(0);
                    default:
                        OutputHandler.displayMessage("Invalid choice. Please enter a valid option.");
                        break;
                }
            }
        } else {
            OutputHandler.displayMessage("Invalid User ID or PIN. Exiting...");
            System.exit(0);
        }
    }
}
