package coffee.order;

public class Order {
    private final int number;
    private final String customerName;

    public Order(int number, String customerName) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name must be provided");
        }
        this.number = number;
        this.customerName = customerName;
    }

    public int getNumber() {
        return number;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return number + " | " + customerName;
    }
}
