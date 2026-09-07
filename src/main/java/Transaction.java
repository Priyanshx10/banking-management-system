import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static long nextTransactionId = 1;

    private final long transactionId;
    private final String type;
    private final double amount;
    private final int accountNumber;
    private final Integer relatedAccountNumber;
    private final LocalDateTime timestamp;
    private final String description;

    public Transaction(
            String type,
            double amount,
            int accountNumber,
            Integer relatedAccountNumber,
            String description) {

        this.transactionId = nextTransactionId++;
        this.type = type;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.relatedAccountNumber = relatedAccountNumber;
        this.timestamp = LocalDateTime.now();
        this.description = description;
    }

    public String getFormattedTimestamp() {
        return timestamp.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        String related = relatedAccountNumber == null
                ? ""
                : " | Related Account: " + relatedAccountNumber;

        return "#" + transactionId
                + " | " + type
                + " | Amount: " + String.format("%.2f", amount)
                + " | " + getFormattedTimestamp()
                + related
                + " | " + description;
    }
}
