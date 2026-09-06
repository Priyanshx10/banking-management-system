import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("     BANKING MANAGEMENT SYSTEM");
        System.out.println("================================");

        System.out.println("1. View Account Details");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        BankAccount account =
                new BankAccount(101201, "Priyansh Yadav", 2000.0);

        switch (choice) {

            case 1:

                System.out.println(
                    "Account Number: " + account.getAccountNumber()
                );

                System.out.println(
                    "Account Holder Name: " +
                    account.getAccountHolderName()
                );

                System.out.println(
                    "Account Balance: " +
                    account.getBalance()
                );

                break;

            case 2:

                System.out.println(
                    "You have selected Deposit Money."
                );

                System.out.print(
                    "Enter the amount to deposit: "
                );

                double depositAmount = scanner.nextDouble();

                account.deposit(depositAmount);

                System.out.println(
                    "Current Balance: " +
                    account.getBalance()
                );

                break;

            case 3:

                System.out.println(
                    "You have selected Withdraw Money."
                );

                System.out.print(
                    "Enter the amount to withdraw: "
                );

                double withdrawAmount = scanner.nextDouble();

                account.withdraw(withdrawAmount);

                System.out.println(
                    "Current Balance: " +
                    account.getBalance()
                );

                break;

            case 4:

                System.out.println(
                    "You have selected Exit."
                );

                break;

            default:

                System.out.println(
                    "Invalid choice."
                );
        }

        scanner.close();
    }
}