import java.util.Scanner;
public class Item {
    private int itemCode;
    private String itemName;
    private double price;
    // Constructor
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    // Method to display item details
    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.printf("Price per unit: ₹%.2f\n", price);
    }
    // Method to calculate total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item code: ");
        int code = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        Item item = new Item(code, name, price);
        System.out.println("\nItem Details:");
        item.displayDetails();
        System.out.print("\nEnter quantity to purchase: ");
        int quantity = scanner.nextInt();
        double totalCost = item.calculateTotalCost(quantity);
        System.out.printf("Total Cost for %d items: ₹%.2f\n", quantity, totalCost);
    }
}