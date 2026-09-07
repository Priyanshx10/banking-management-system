import java.util.Scanner;

public class Main {
    private static final BankingService bankingService =
            new BankingService();

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void main(String[] args) {
        seedDemoData();

        int choice = 0;

        while (choice != 11) {
            printMenu();
            choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1 -> viewAllAccounts();
                    case 2 -> deposit();
                    case 3 -> withdraw();
                    case 4 -> transfer();
                    case 5 -> viewTransactions();
                    case 6 -> createSavingsAccount();
                    case 7 -> createCurrentAccount();
                    case 8 -> applySavingsInterest();
                    case 9 -> viewAccount();
                    case 10 -> createCustomer();
                    case 11 -> printExitMessage();
                    default ->
                            System.out.println(
                                    "Invalid choice. Please try again.");
                }
            } catch (BankingException |
                     IllegalArgumentException exception) {

                System.out.println(
                        "Operation failed: "
                                + exception.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("========================================");
        System.out.println("       BANKING MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. View All Accounts");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Transaction History");
        System.out.println("6. Create Savings Account");
        System.out.println("7. Create Current Account");
        System.out.println("8. Apply Savings Interest");
        System.out.println("9. View Account");
        System.out.println("10. Create Customer");
        System.out.println("11. Exit");
    }

    private static void seedDemoData() {
        Customer customer =
                bankingService.createCustomer(
                        1,
                        "Priyansh Yadav",
                        "priyansh@example.com");

        BankAccount account =
                bankingService.createSavingsAccount(
                        customer.getCustomerId(),
                        2000.0,
                        4.0);

        System.out.println(
                "Demo account created. Account Number: "
                        + account.getAccountNumber());

        System.out.println();
    }

    private static void createCustomer() {
        int customerId =
                readInt("Customer ID: ");

        String name =
                readText("Customer name: ");

        String email =
                readText("Customer email: ");

        Customer customer =
                bankingService.createCustomer(
                        customerId,
                        name,
                        email);

        System.out.println(
                "Customer created successfully: "
                        + customer.getCustomerId());
    }

    private static void viewAllAccounts() {
        for (BankAccount account :
                bankingService.getAllAccounts()) {

            printAccountSummary(account);
        }
    }

    private static void viewAccount() {
        int accountNumber =
                readInt("Enter account number: ");

        BankAccount account =
                bankingService.getAccount(accountNumber);

        System.out.println(
                "========================================");

        System.out.println(
                "           ACCOUNT DETAILS");

        System.out.println(
                "========================================");

        System.out.println(
                "Customer ID: "
                        + account.getCustomer().getCustomerId());

        System.out.println(
                "Customer Name: "
                        + account.getCustomer().getName());

        System.out.println(
                "Customer Email: "
                        + account.getCustomer().getEmail());

        System.out.println(
                "Account Number: "
                        + account.getAccountNumber());

        System.out.println(
                "Account Type: "
                        + account.getAccountType());

        System.out.printf(
                "Balance: %.2f%n",
                account.getBalance());

        System.out.println(
                "========================================");
    }

    private static void printAccountSummary(
            BankAccount account) {

        System.out.printf(
                "Account #%d | %-8s | %-20s | Balance: %.2f%n",
                account.getAccountNumber(),
                account.getAccountType(),
                account.getCustomer().getName(),
                account.getBalance());
    }

    private static void deposit() {
        int accountNumber =
                readInt("Enter account number: ");

        double amount =
                readDouble("Enter amount to deposit: ");

        BankAccount account =
                bankingService.getAccount(accountNumber);

        account.deposit(amount);

        System.out.printf(
                "Deposit successful. Balance: %.2f%n",
                account.getBalance());
    }

    private static void withdraw() {
        int accountNumber =
                readInt("Enter account number: ");

        double amount =
                readDouble("Enter amount to withdraw: ");

        BankAccount account =
                bankingService.getAccount(accountNumber);

        account.withdraw(amount);

        System.out.printf(
                "Withdrawal successful. Balance: %.2f%n",
                account.getBalance());
    }

    private static void transfer() {
        int from =
                readInt("From account: ");

        int to =
                readInt("To account: ");

        double amount =
                readDouble("Transfer amount: ");

        bankingService.transfer(
                from,
                to,
                amount);

        System.out.println(
                "Transfer successful.");
    }

    private static void viewTransactions() {
        int accountNumber =
                readInt("Enter account number: ");

        bankingService.printTransactionHistory(
                accountNumber);
    }

    private static void createSavingsAccount() {
        int customerId =
                readInt("Customer ID: ");

        double balance =
                readDouble("Initial balance: ");

        double rate =
                readDouble(
                        "Annual interest rate (%): ");

        BankAccount account =
                bankingService.createSavingsAccount(
                        customerId,
                        balance,
                        rate);

        System.out.println(
                "Savings account created: "
                        + account.getAccountNumber());
    }

    private static void createCurrentAccount() {
        int customerId =
                readInt("Customer ID: ");

        double balance =
                readDouble("Initial balance: ");

        BankAccount account =
                bankingService.createCurrentAccount(
                        customerId,
                        balance);

        System.out.println(
                "Current account created: "
                        + account.getAccountNumber());
    }

    private static void applySavingsInterest() {
        int accountNumber =
                readInt("Savings account number: ");

        BankAccount account =
                bankingService.getAccount(accountNumber);

        if (!(account instanceof SavingsAccount savingsAccount)) {
            throw new BankingException(
                    "This is not a savings account.");
        }

        double interest =
                savingsAccount.calculateInterest();

        savingsAccount.applyInterest();

        System.out.printf(
                "Interest applied: %.2f%n",
                interest);

        System.out.printf(
                "New balance: %.2f%n",
                savingsAccount.getBalance());
    }

    private static void printExitMessage() {
        System.out.println(
                "========================================");

        System.out.println(
                "Thank you for using the Banking Management System.");

        System.out.println(
                "Goodbye!");

        System.out.println(
                "========================================");
    }

    private static int readInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private static double readDouble(String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }

    private static String readText(String message) {
        System.out.print(message);
        scanner.nextLine();
        return scanner.nextLine();
    }
}
