import java.util.*;

// Interface: Discountable
interface Discountable {
    void applyDiscount(double percent);
    double getDiscountDetails();
}

// Abstract class: FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    private double discount = 0.0;

    public FoodItem(String itemName, double price, int quantity) {
        setItemName(itemName);
        setPrice(price);
        setQuantity(quantity);
    }

    // Encapsulation
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Item name cannot be empty.");
        this.itemName = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        this.quantity = quantity;
    }

    protected void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount Applied: ₹" + discount);
    }

    public abstract double calculateTotalPrice();
}

// VegItem
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public void applyDiscount(double percent) {
        double discount = getPrice() * getQuantity() * percent / 100;
        setDiscount(discount);
    }

    @Override
    public double getDiscountDetails() {
        return getDiscount();
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - getDiscount();
    }
}

// NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    private double nonVegCharge = 20.0; // Flat extra per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public void applyDiscount(double percent) {
        double discount = getPrice() * getQuantity() * percent / 100;
        setDiscount(discount);
    }

    @Override
    public double getDiscountDetails() {
        return getDiscount();
    }

    @Override
    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        double total = base + (nonVegCharge * getQuantity());
        return total - getDiscount();
    }
}

// Main class
public class FoodDeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<FoodItem> orders = new ArrayList<>();

        System.out.print("Enter number of food items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nItem " + (i + 1));
            System.out.print("Enter item type (Veg/NonVeg): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter item name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            sc.nextLine(); // clear buffer

            FoodItem item = null;

            switch (type) {
                case "veg":
                    item = new VegItem(name, price, qty);
                    break;
                case "nonveg":
                    item = new NonVegItem(name, price, qty);
                    break;
                default:
                    System.out.println("Invalid type. Skipping.");
                    continue;
            }

            System.out.print("Apply discount (%)? Enter 0 if none: ");
            double discountPercent = sc.nextDouble();
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(discountPercent);
            }

            orders.add(item);
            sc.nextLine(); // clear buffer
        }

        System.out.println("\n=== Order Summary ===");
        double grandTotal = 0;
        for (FoodItem item : orders) {
            System.out.println("--------------------------");
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            System.out.printf("Total Price: ₹%.2f\n", total);
            grandTotal += total;
        }

        System.out.printf("\nGrand Total for All Items: ₹%.2f\n", grandTotal);
        sc.close();
    }
}
