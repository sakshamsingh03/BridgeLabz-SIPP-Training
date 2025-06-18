import java.util.Scanner;

public class Chocolates {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input the number of chocolates and number of children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        // Find the quotient and remainder
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        // Output the result
        System.out.println("Each child will get: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);

        // Close the scanner
        input.close();
    }

    // Method to find the number of chocolates each child gets and the remaining
    // chocolates
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        // Calculate quotient and remainder
        int quotient = number / divisor;
        int remainder = number % divisor;

        // Return the results as an array
        return new int[] { quotient, remainder };
    }
}