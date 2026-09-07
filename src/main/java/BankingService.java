import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BankingService {
    private final Map<Integer, Customer> customers = new LinkedHashMap<>();
    private final Map<Integer, BankAccount> accounts = new LinkedHashMap<>();

    public Customer createCustomer(
            int customerId,
            String name,
            String email) {

        if (customers.containsKey(customerId)) {
            throw new BankingException(
                    "Customer ID already exists.");
        }

        Customer customer =
                new Customer(customerId, name, email);

        customers.put(customerId, customer);
        return customer;
    }

    public BankAccount createSavingsAccount(
            int customerId,
            double initialBalance,
            double annualInterestRate) {

        Customer customer = getCustomer(customerId);

        BankAccount account =
                new SavingsAccount(
                        customer,
                        initialBalance,
                        annualInterestRate);

        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    public BankAccount createCurrentAccount(
            int customerId,
            double initialBalance) {

        Customer customer = getCustomer(customerId);

        BankAccount account =
                new CurrentAccount(
                        customer,
                        initialBalance);

        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    public Customer getCustomer(int customerId) {
        Customer customer = customers.get(customerId);

        if (customer == null) {
            throw new BankingException("Customer not found.");
        }

        return customer;
    }

    public BankAccount getAccount(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            throw new BankingException("Account not found.");
        }

        return account;
    }

    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    public void transfer(
            int fromAccountNumber,
            int toAccountNumber,
            double amount) {

        if (fromAccountNumber == toAccountNumber) {
            throw new BankingException(
                    "Source and destination accounts must be different.");
        }

        if (amount <= 0) {
            throw new BankingException(
                    "Transfer amount must be greater than 0.");
        }

        BankAccount from = getAccount(fromAccountNumber);
        BankAccount to = getAccount(toAccountNumber);

        from.withdraw(
                amount,
                toAccountNumber,
                "Transfer to account " + toAccountNumber);

        to.deposit(
                amount,
                fromAccountNumber,
                "Transfer from account " + fromAccountNumber);
    }

    public void printTransactionHistory(int accountNumber) {
        BankAccount account = getAccount(accountNumber);
        List<Transaction> transactions =
                account.getTransactions();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
