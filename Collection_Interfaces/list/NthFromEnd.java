package com.interfac.list;

import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        String result = findNthFromEnd(list, n);
        System.out.println("Nth element from end: " + result);
    }

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        // Use two iterators (fast and slow)
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("N is greater than the list size");
            }
            fast.next();
        }

        // Move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // Slow now points to the N-th element from the end
        return slow.next();
    }
}
