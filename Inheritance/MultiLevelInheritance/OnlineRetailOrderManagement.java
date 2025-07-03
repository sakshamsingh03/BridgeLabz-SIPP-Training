// Base class
class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order placed on " + orderDate;
    }

    void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }
}

// Subclass: ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order shipped. Tracking Number: " + trackingNumber;
    }

    @Override
    void displayOrder() {
        super.displayOrder();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass: DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }

    @Override
    void displayOrder() {
        super.displayOrder();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class to test
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        System.out.println("--- Order ---");
        Order order = new Order("ORD001", "2025-07-01");
        order.displayOrder();
        System.out.println("Status: " + order.getOrderStatus());

        System.out.println("\n--- Shipped Order ---");
        ShippedOrder shipped = new ShippedOrder("ORD002", "2025-07-01", "TRACK123");
        shipped.displayOrder();
        System.out.println("Status: " + shipped.getOrderStatus());

        System.out.println("\n--- Delivered Order ---");
        DeliveredOrder delivered = new DeliveredOrder("ORD003", "2025-07-01", "TRACK456", "2025-07-05");
        delivered.displayOrder();
        System.out.println("Status: " + delivered.getOrderStatus());
    }
}
