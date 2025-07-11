package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

public class Main {
	public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Sample Inventory Operations
        inventory.addAtEnd("Laptop", 101, 10, 55000);
        inventory.addAtBeginning("Mouse", 102, 50, 500);
        inventory.addAtEnd("Keyboard", 103, 30, 1500);
        inventory.addAtPosition(2, "Monitor", 104, 20, 12000);

        System.out.println("All Inventory Items:");
        inventory.displayAll();

        System.out.println("\nSearching for Item ID 103:");
        inventory.searchItem("103");

        System.out.println("\nUpdating Quantity for Item ID 104:");
        inventory.updateQuantity(104, 25);
        inventory.displayAll();

        System.out.println("\nTotal Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSorting Inventory by Name (Ascending):");
        inventory.sortInventory("name", true);
        inventory.displayAll();

        System.out.println("\nSorting Inventory by Price (Descending):");
        inventory.sortInventory("price", false);
        inventory.displayAll();

        System.out.println("\nRemoving Item ID 102:");
        inventory.removeByItemId(102);
        inventory.displayAll();
    }
}