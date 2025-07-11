
import java.util.Scanner;
import java.util.Stack;

public class SortStackUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        // Input: Number of elements and the stack elements
        System.out.print("Enter the number of elements in the stack: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the stack:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        // Sort the stack recursively
        sortStack(stack);

        // Display sorted stack (top to bottom)
        System.out.println("Sorted Stack (Top to Bottom):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // Close the scanner
        sc.close();
    }

    // Recursive function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, temp);
        }
    }

    // Recursive function to insert an element into sorted stack
    public static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }
}