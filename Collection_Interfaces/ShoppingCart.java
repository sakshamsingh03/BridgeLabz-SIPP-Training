package com.interfac;

import java.util.*;

public class ShoppingCart {
    // Product database: productName → price
    private Map<String, Double> productPrices = new HashMap<>();

    // Cart with order: productName → quantity (maintains insertion order)
    private Map<String, Integer> cart = new LinkedHashMap<>();

    // Add a product to the product catalog
    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    // Add item to cart
    public void addToCart(String productName, int quantity) {
        if (!productPrices.containsKey(productName)) {
            System.out.println("Product not found: " + productName);
            return;
        }
        cart.put(productName, cart.getOrDefault(productName, 0) + quantity);
        System.out.println(quantity + " x " + productName + " added to cart.");
    }

    // Display cart in insertion order
    public void displayCartInOrder() {
        System.out.println("\nCart (in order added):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = productPrices.get(product);
            System.out.printf("%s - %d x ₹%.2f = ₹%.2f%n", product, qty, price, qty * price);
        }
    }

    // Display cart sorted by product price (ascending)
    public void displayCartSortedByPrice() {
        System.out.println("\nCart (sorted by price):");

        // Create TreeMap with comparator to sort by price
        TreeMap<String, Double> sortedByPrice = new TreeMap<>(
            Comparator.comparingDouble(productPrices::get)
        );

        // Add only cart items to the TreeMap
        for (String product : cart.keySet()) {
            sortedByPrice.put(product, productPrices.get(product));
        }

        for (String product : sortedByPrice.keySet()) {
            int qty = cart.get(product);
            double price = productPrices.get(product);
            System.out.printf("%s - %d x ₹%.2f = ₹%.2f%n", product, qty, price, qty * price);
        }
    }

    // Total cost
    public void displayTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        System.out.printf("\nTotal: ₹%.2f%n", total);
    }

    // Main method for testing
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add products
        cart.addProduct("Milk", 45.0);
        cart.addProduct("Bread", 30.0);
        cart.addProduct("Butter", 70.0);
        cart.addProduct("Eggs", 60.0);

        // Add to cart
        cart.addToCart("Milk", 2);
        cart.addToCart("Bread", 1);
        cart.addToCart("Eggs", 1);
        cart.addToCart("Butter", 1);

        // Display all views
        cart.displayCartInOrder();
        cart.displayCartSortedByPrice();
        cart.displayTotal();
    }
}
