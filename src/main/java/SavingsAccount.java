public class SavingsAccount extends BankAccount {
    private final double annualInterestRate;

    public SavingsAccount(
            Customer customer,
            double initialBalance,
            double annualInterestRate) {

        super(customer, initialBalance);

        if (annualInterestRate < 0) {
            throw new IllegalArgumentException(
                    "Interest rate cannot be negative.");
        }

        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }

    @Override
    public double calculateInterest() {
        return getBalance() * annualInterestRate / 100.0;
    }

    public void applyInterest() {
        double interest = calculateInterest();

        if (interest > 0) {
            addInterestTransaction(
                    interest,
                    "Annual savings interest applied");
        }
    }
}
