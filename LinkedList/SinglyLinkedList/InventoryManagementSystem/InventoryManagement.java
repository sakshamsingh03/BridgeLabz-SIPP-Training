package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

class InventoryManagement {
    private Item head;

    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    // Add item at a specific position (1-based indexing)
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        Item newItem = new Item(itemName, itemId, quantity, price);
        Item current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newItem.next = current.next;
        current.next = newItem;
    }

    // Remove item by Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }
        Item current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Item removed successfully.");
        }
    }

    // Update quantity by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found.");
    }

    // Search item by Item ID or Item Name
    public void searchItem(String searchKey) {
        boolean found = false;
        Item current = head;
        while (current != null) {
            if (String.valueOf(current.itemId).equals(searchKey) ||
                current.itemName.equalsIgnoreCase(searchKey)) {
                displayItem(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        System.out.println("Total Inventory Value: ₹" + totalValue);
    }

    // Sort inventory by Item Name or Price (ascending/descending)
    public void sortInventory(String sortBy, boolean ascending) {
        head = mergeSort(head, sortBy, ascending);
        System.out.println("Inventory sorted by " + sortBy + " (" + (ascending ? "Ascending" : "Descending") + ").");
    }

    // Merge Sort for Linked List
    private Item mergeSort(Item head, String sortBy, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, sortBy, ascending);
        Item right = mergeSort(nextOfMiddle, sortBy, ascending);

        return sortedMerge(left, right, sortBy, ascending);
    }

    // Merging two sorted lists
    private Item sortedMerge(Item a, Item b, String sortBy, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        int compare;
        if (sortBy.equalsIgnoreCase("name")) {
            compare = a.itemName.compareToIgnoreCase(b.itemName);
        } else { // Sort by price
            compare = Double.compare(a.price, b.price);
        }

        if ((ascending && compare <= 0) || (!ascending && compare >= 0)) {
            a.next = sortedMerge(a.next, b, sortBy, ascending);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, sortBy, ascending);
            return b;
        }
    }

    // Find middle node for merge sort
    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items
    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item current = head;
        while (current != null) {
            displayItem(current);
            current = current.next;
        }
    }

    // Helper to display item details
    private void displayItem(Item item) {
        System.out.println("Item Name: " + item.itemName);
        System.out.println("Item ID: " + item.itemId);
        System.out.println("Quantity: " + item.quantity);
        System.out.println("Price: ₹" + item.price);
        System.out.println("----------------------------------");
    }
}