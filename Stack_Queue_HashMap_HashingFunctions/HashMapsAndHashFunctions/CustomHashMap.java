import java.util.*;

class CustomHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16;
    private Node<K, V>[] buckets;

    public CustomHashMap() {
        buckets = new Node[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = buckets[index];

        for (Node<K, V> curr = head; curr != null; curr = curr.next) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> curr = buckets[index];
        while (curr != null) {
            if (curr.key.equals(key)) return curr.value;
            curr = curr.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> curr = buckets[index];
        Node<K, V> prev = null;

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) buckets[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + ": ");
            Node<K, V> curr = buckets[i];
            while (curr != null) {
                System.out.print("[" + curr.key + "=" + curr.value + "] -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomHashMap<String, String> map = new CustomHashMap<>();
        while (true) {
            System.out.println("\n1. Put\n2. Get\n3. Remove\n4. Display\n5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear newline
            if (choice == 1) {
                System.out.print("Enter key: ");
                String key = sc.nextLine();
                System.out.print("Enter value: ");
                String value = sc.nextLine();
                map.put(key, value);
            } else if (choice == 2) {
                System.out.print("Enter key: ");
                String key = sc.nextLine();
                String value = map.get(key);
                System.out.println("Value: " + value);
            } else if (choice == 3) {
                System.out.print("Enter key: ");
                String key = sc.nextLine();
                map.remove(key);
            } else if (choice == 4) {
                map.display();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
