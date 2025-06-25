import java.util.ArrayList;
import java.util.Scanner;
class CartItem {
    // Attributes
    String itemName;
    double price;
    int quantity;

    // Constructor
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to get total price for this item
    public double getTotalPrice() {
        return price * quantity;
    }
}

class ShoppingCart {
    private static ArrayList<CartItem> cart = new ArrayList<>();

    // Method to add item
    public static void addItem(String name, double price, int quantity) {
        cart.add(new CartItem(name, price, quantity));
        System.out.println("Item added successfully.");
    }

    // Method to remove item by name
    public static void removeItem(String name) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(name)) {
                cart.remove(i);
                removed = true;
                System.out.println("Item removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Item not found in the cart.");
        }
    }

    // Method to display total cost
    public static void displayTotalCost() {
        double total = 0;
        System.out.println("\n--- Cart Summary ---");
        for (CartItem item : cart) {
            System.out.printf("%s - ₹%.2f x %d = ₹%.2f\n", 
                item.itemName, item.price, item.quantity, item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.printf("Total Cost: ₹%.2f\n", total);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Shopping Cart!");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Total Cost");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    addItem(name, price, qty);
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    removeItem(itemToRemove);
                    break;

                case 3:
                    displayTotalCost();
                    break;

                case 4:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}