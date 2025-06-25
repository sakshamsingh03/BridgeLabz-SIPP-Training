public class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(int accNum, String accHolder, double bal) {
        super(accNum, accHolder, bal);
    }

    public void showAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolder);
    }
}
