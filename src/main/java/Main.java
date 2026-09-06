public class Main {

    public static void main(String[] args) {

        System.out.println("Banking Management System!");

        BankAccount account = new BankAccount(101201, "Priyansh Yadav", 2000.0);

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Account Balance: " + account.getBalance());

        account.deposit(500.0);
        System.out.println("Account Balance After Deposit: " + account.getBalance());

        account.withdraw(2800.0);
        System.out.println("Account Balance After Withdraw: " + account.getBalance());
    }
}