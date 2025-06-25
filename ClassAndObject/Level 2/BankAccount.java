import java.util.Scanner;
public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully.\n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully.\n", amount);
        }
    }
    // Method to display current balance
    public void displayBalance() {
        System.out.printf("Current Balance: ₹%.2f\n", balance);
    }
    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        displayBalance();
    }
    // Main method to test the class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String holder = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(holder, accNumber, initBalance);
        account.displayAccountDetails();
        // Menu-driven interaction
        int choice;
        do {
            System.out.println("\nBank Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depAmount = scanner.nextDouble();
                    account.deposit(depAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withAmount = scanner.nextDouble();
                    account.withdraw(withAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the bank system.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }
}