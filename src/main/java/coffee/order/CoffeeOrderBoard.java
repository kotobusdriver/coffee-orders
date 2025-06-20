package coffee.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CoffeeOrderBoard {
    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    private final List<Order> orders = new LinkedList<>();
    private int lastOrderNumber = 0;

    public void add(String customerName) {
        lastOrderNumber++;
        Order order = new Order(lastOrderNumber, customerName);
        orders.add(order);
        log.info("Added order #{} for {}", order.getNumber(), customerName);
    }

    public void deliver() {
        if (orders.isEmpty()) {
            log.warn("No orders to deliver");
        }
        Order next = orders.removeFirst();
        log.info("Delivered next order: #{} for {}", next.getNumber(), next.getCustomerName());
    }

    public Optional<Order> deliver(int orderNumber) {
        Optional<Order> found = orders.stream()
                .filter(o -> o.getNumber() == orderNumber)
                .findFirst();
        if (found.isEmpty()) {
            log.error("Tried to deliver non-existent order #{}", orderNumber);
            return null;
        }
        Order order = found.get();
        orders.remove(order);
        log.info("Delivered order #{} for {} (ready before time)", order.getNumber(), order.getCustomerName());
        return Optional.of(order);
    }

    public void draw() {
        log.debug("Print order board ({} orders)", orders.size());
        System.out.println("Num | Name");
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
