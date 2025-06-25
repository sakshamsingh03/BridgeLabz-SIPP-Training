class BankAccount {
    static String bankName = "ABC Bank";
    static int totalAccounts = 0;

    final String accountNumber;
    String accountHolderName;

    BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void display() {
        if (this instanceof BankAccount) {
            System.out.println("Account Holder: " + accountHolderName + ", Account Number: " + accountNumber);
        }
    }
}
