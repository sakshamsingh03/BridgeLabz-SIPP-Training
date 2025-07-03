import java.util.*;

// Interface: Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Abstract Class: LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean reserved;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.reserved = false;
    }

    // Encapsulation
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Reserved: " + reserved);
    }

    public abstract int getLoanDuration();
}

// Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 21 days
    }

    @Override
    public void reserveItem() {
        if (!isReserved()) {
            setReserved(true);
            System.out.println("Book reserved successfully!");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// Magazine
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem() {
        if (!isReserved()) {
            setReserved(true);
            System.out.println("Magazine reserved successfully!");
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days
    }

    @Override
    public void reserveItem() {
        if (!isReserved()) {
            setReserved(true);
            System.out.println("DVD reserved successfully!");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<LibraryItem> catalog = new ArrayList<>();

        System.out.print("Enter number of items to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nItem " + (i + 1));
            System.out.print("Enter type (Book/Magazine/DVD): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter Item ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            switch (type) {
                case "book":
                    catalog.add(new Book(id, title, author));
                    break;
                case "magazine":
                    catalog.add(new Magazine(id, title, author));
                    break;
                case "dvd":
                    catalog.add(new DVD(id, title, author));
                    break;
                default:
                    System.out.println("Invalid type. Skipping...");
            }
        }

        System.out.println("\n=== Library Catalog Summary ===");
        for (LibraryItem item : catalog) {
            System.out.println("-------------------------------");
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
        }

        System.out.println("\n=== Reservation System ===");
        for (LibraryItem item : catalog) {
            System.out.println("-------------------------------");
            item.getItemDetails();
            if (item instanceof Reservable) {
                System.out.println("Available: " + ((Reservable) item).checkAvailability());
                System.out.print("Do you want to reserve this item? (yes/no): ");
                String choice = sc.nextLine().trim().toLowerCase();
                if (choice.equals("yes")) {
                    ((Reservable) item).reserveItem();
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
