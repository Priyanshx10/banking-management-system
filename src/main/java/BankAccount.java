public class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println(
                "Deposit amount should be greater than 0."
            );
        }
    }

    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println(
                "Withdrawal amount should be greater than 0."
            );

        } else if (amount > balance) {

            System.out.println(
                "Insufficient balance."
            );

        } else {

            balance -= amount;
        }
    }
}