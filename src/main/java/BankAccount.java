import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BankAccount {
    private static int nextAccountNumber = 100001;

    private final int accountNumber;
    private final Customer customer;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    protected BankAccount(Customer customer, double initialBalance) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is required.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative.");
        }

        this.accountNumber = nextAccountNumber++;
        this.customer = customer;
        this.balance = initialBalance;

        if (initialBalance > 0) {
            transactions.add(new Transaction(
                    "OPENING_DEPOSIT",
                    initialBalance,
                    accountNumber,
                    null,
                    "Initial account balance"));
        }
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
        deposit(amount, null, "Cash deposit");
    }

    protected void deposit(
            double amount,
            Integer relatedAccountNumber,
            String description) {

        validatePositiveAmount(amount);
        balance += amount;

        transactions.add(new Transaction(
                "DEPOSIT",
                amount,
                accountNumber,
                relatedAccountNumber,
                description));
    }

    public void withdraw(double amount) {
        withdraw(amount, null, "Cash withdrawal");
    }

    protected void withdraw(
            double amount,
            Integer relatedAccountNumber,
            String description) {

        validatePositiveAmount(amount);

        if (amount > balance) {
            throw new BankingException("Insufficient balance.");
        }

        balance -= amount;

        transactions.add(new Transaction(
                "WITHDRAWAL",
                amount,
                accountNumber,
                relatedAccountNumber,
                description));
    }

    protected void addInterestTransaction(
            double amount,
            String description) {

        validatePositiveAmount(amount);
        balance += amount;

        transactions.add(new Transaction(
                "INTEREST",
                amount,
                accountNumber,
                null,
                description));
    }

    private void validatePositiveAmount(double amount) {
        if (amount <= 0) {
            throw new BankingException(
                    "Amount must be greater than 0.");
        }
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public abstract String getAccountType();

    public double calculateInterest() {
        return 0.0;
    }
}
