import java.util.*;

// Interface: Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Class: Product
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        setPrice(price);
    }

    // Encapsulation
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0) throw new IllegalArgumentException("Price can't be negative.");
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }
}

// Electronics implements Taxable
class Electronics extends Product implements Taxable {
    private int warrantyYears;

    public Electronics(String productId, String name, double price, int warrantyYears) {
        super(productId, name, price);
        this.warrantyYears = warrantyYears;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applicable";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Warranty: " + warrantyYears + " year(s)");
        System.out.println(getTaxDetails());
    }
}

// Clothing implements Taxable
class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(String productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% VAT
    }

    @Override
    public String getTaxDetails() {
        return "5% VAT applicable";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Size: " + size);
        System.out.println(getTaxDetails());
    }
}

// Groceries (no tax)
class Groceries extends Product {
    private String expiryDate;

    public Groceries(String productId, String name, double price, String expiryDate) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("No tax applicable");
    }
}

// Main Class
public class ECommercePlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        System.out.print("Enter number of products to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1));
            System.out.print("Enter product type (Electronics/Clothing/Groceries): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter Product ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // consume newline

            switch (type) {
                case "electronics":
                    System.out.print("Enter Warranty Years: ");
                    int warranty = sc.nextInt();
                    sc.nextLine();
                    productList.add(new Electronics(id, name, price, warranty));
                    break;

                case "clothing":
                    System.out.print("Enter Size (S/M/L/XL): ");
                    String size = sc.nextLine();
                    productList.add(new Clothing(id, name, price, size));
                    break;

                case "groceries":
                    System.out.print("Enter Expiry Date (dd-mm-yyyy): ");
                    String expiry = sc.nextLine();
                    productList.add(new Groceries(id, name, price, expiry));
                    break;

                default:
                    System.out.println("Invalid product type. Skipping...");
                    break;
            }
        }

        // Display summary
        System.out.println("\n=== Product Summary ===");
        for (Product p : productList) {
            System.out.println("-------------------------");
            p.displayInfo();

            double discount = p.calculateDiscount();
            double tax = 0;
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
            }

            double finalPrice = p.getPrice() + tax - discount;

            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Tax: $%.2f%n", tax);
            System.out.printf("Final Price: $%.2f%n", finalPrice);
        }

        sc.close();
    }
}
