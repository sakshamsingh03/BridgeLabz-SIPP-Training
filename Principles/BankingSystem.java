import java.util.*;

// Interface: Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract Class: BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        setBalance(balance);
    }

    // Encapsulation
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative.");
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }

    // Abstract
    public abstract double calculateInterest();
}

// SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;
    private boolean loanApproved = false;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Applying for loan of $" + amount);
        loanApproved = amount <= (getBalance() * 5);
        if (loanApproved) {
            System.out.println("Loan approved!");
        } else {
            System.out.println("Loan denied: Insufficient eligibility.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return loanApproved;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CurrentAccount
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;
    private boolean loanApproved = false;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // Typically, no interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Applying for loan of $" + amount);
        loanApproved = amount <= overdraftLimit * 2;
        if (loanApproved) {
            System.out.println("Loan approved!");
        } else {
            System.out.println("Loan denied: Exceeds limit.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return loanApproved;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Current");
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts to create: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nAccount " + (i + 1));
            System.out.print("Enter account type (Savings/Current): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter Account Number: ");
            String accNum = sc.nextLine();

            System.out.print("Enter Holder Name: ");
            String holder = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();

            switch (type) {
                case "savings":
                    System.out.print("Enter Interest Rate (%): ");
                    double rate = sc.nextDouble();
                    sc.nextLine();
                    accounts.add(new SavingsAccount(accNum, holder, balance, rate));
                    break;

                case "current":
                    System.out.print("Enter Overdraft Limit: ");
                    double limit = sc.nextDouble();
                    sc.nextLine();
                    accounts.add(new CurrentAccount(accNum, holder, balance, limit));
                    break;

                default:
                    System.out.println("Invalid type. Skipping...");
            }
        }

        System.out.println("\n=== Account Summary ===");
        for (BankAccount acc : accounts) {
            System.out.println("---------------------------");
            acc.displayDetails();
            double interest = acc.calculateInterest();
            System.out.printf("Calculated Interest: $%.2f%n", interest);
        }

        System.out.println("\n=== Transactions & Loan Applications ===");
        for (BankAccount acc : accounts) {
            System.out.println("---------------------------");
            acc.displayDetails();

            System.out.print("Enter amount to deposit: ");
            double dep = sc.nextDouble();
            acc.deposit(dep);

            System.out.print("Enter amount to withdraw: ");
            double wd = sc.nextDouble();
            acc.withdraw(wd);

            if (acc instanceof Loanable) {
                System.out.print("Enter loan amount to apply for: ");
                double loanAmt = sc.nextDouble();
                ((Loanable) acc).applyForLoan(loanAmt);
                System.out.println("Loan Eligibility: " + ((Loanable) acc).calculateLoanEligibility());
            }

            System.out.println();
        }

        sc.close();
    }
}
