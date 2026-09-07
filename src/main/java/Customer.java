public class Customer {
    private final int customerId;
    private final String name;
    private final String email;

    public Customer(int customerId, String name, String email) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be greater than 0.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name is required.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Customer email is required.");
        }

        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
