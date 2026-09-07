public class BankAccount {

    private int accountNumber;
    private Customer customer;
    private double balance;

    public BankAccount(int accountNumber, Customer customer, double balance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
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