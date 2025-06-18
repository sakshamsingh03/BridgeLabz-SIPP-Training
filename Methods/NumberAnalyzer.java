import java.util.Scanner;

public class NumberAnalyzer {

    // Method to check if a number is positive
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    // Method to check if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Method to compare two numbers
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // Take input
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        // Analyze each number
        System.out.println("\n--- Analysis ---");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + numbers[i] + " is ");

            if (isPositive(numbers[i])) {
                System.out.print("Positive and ");
                if (isEven(numbers[i])) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else {
                System.out.println("Negative");
            }
        }

        // Compare first and last elements
        int result = compare(numbers[0], numbers[4]);
        System.out.println("\n--- Comparison of First and Last Element ---");
        if (result == 0) {
            System.out.println("First and last numbers are equal.");
        } else if (result == 1) {
            System.out.println("First number is greater than the last number.");
        } else {
            System.out.println("First number is less than the last number.");
        }
    }
}
