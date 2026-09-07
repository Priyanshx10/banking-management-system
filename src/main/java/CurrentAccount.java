public class CurrentAccount extends BankAccount {

    public CurrentAccount(
            Customer customer,
            double initialBalance) {

        super(customer, initialBalance);
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}
