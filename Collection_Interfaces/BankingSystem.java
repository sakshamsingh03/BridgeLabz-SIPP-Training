package com.interfac;

import java.util.*;

//Class representing a withdrawal request
class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

// Main Banking System
public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add customer account
    public void addAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        System.out.println("Account added: " + accountNumber + " → ₹" + initialBalance);
    }

    // Request a withdrawal
    public void requestWithdrawal(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request queued for " + accountNumber + ": ₹" + amount);
    }

    // Process all withdrawals in FIFO order
    public void processWithdrawals() {
        System.out.println("\nProcessing withdrawals...");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            double balance = accounts.getOrDefault(req.accountNumber, 0.0);

            if (req.amount <= balance) {
                accounts.put(req.accountNumber, balance - req.amount);
                System.out.println("Processed: " + req.accountNumber + " → ₹" + req.amount + " withdrawn");
            } else {
                System.out.println("Insufficient funds for " + req.accountNumber + " → Requested: ₹" + req.amount
                        + ", Available: ₹" + balance);
            }
        }
    }

    // Display accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts sorted by balance:");

        // Create TreeMap with custom comparator to sort by balance
        TreeMap<String, Double> sorted = new TreeMap<>(
                Comparator.comparingDouble(accounts::get));
        sorted.putAll(accounts);

        for (String acc : sorted.keySet()) {
            System.out.println(acc + " → ₹" + accounts.get(acc));
        }
    }

    // Display all accounts
    public void displayAllAccounts() {
        System.out.println("\nAll accounts:");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println(entry.getKey() + " → ₹" + entry.getValue());
        }
    }

    // Main for testing
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("ACC1001", 5000);
        bank.addAccount("ACC1002", 3000);
        bank.addAccount("ACC1003", 7000);

        bank.requestWithdrawal("ACC1002", 1000);
        bank.requestWithdrawal("ACC1001", 6000); // Should fail
        bank.requestWithdrawal("ACC1003", 2500);

        bank.processWithdrawals();
        bank.displayAllAccounts();
        bank.displayAccountsSortedByBalance();
    }
}
