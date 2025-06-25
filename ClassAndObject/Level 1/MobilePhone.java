import java.util.Scanner;
public class MobilePhone {
    private String brand;
    private String model;
    private double price;
    // Constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    // Method to display phone details
    public void displayDetails() {
        System.out.println("\nMobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.printf("Price: ₹%.2f\n", price);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter phone model: ");
        String model = scanner.nextLine();
        System.out.print("Enter phone price: ");
        double price = scanner.nextDouble();
        MobilePhone phone = new MobilePhone(brand, model, price);
        phone.displayDetails();
    }
}