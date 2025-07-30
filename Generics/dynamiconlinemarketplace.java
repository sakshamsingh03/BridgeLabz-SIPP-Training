
interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100.0);
        product.setPrice(product.getPrice() - discountAmount);
    }
}

class GadgetCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println(category.getCategoryName() + " - " + name + ": ₹" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create products with different categories
        Product<BookCategory> book = new Product<>("Java Programming", 500.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 800.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000.0, new GadgetCategory());

        System.out.println("Before Discount:");
        book.display();
        shirt.display();
        phone.display();

        // Apply discounts
        DiscountUtil.applyDiscount(book, 10); // 10% discount on book
        DiscountUtil.applyDiscount(shirt, 20); // 20% discount on clothing
        DiscountUtil.applyDiscount(phone, 5); // 5% discount on gadgets

        System.out.println("\nAfter Discount:");
        book.display();
        shirt.display();
        phone.display();
    }
}