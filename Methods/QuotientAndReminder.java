import java.util.Scanner;

public class QuotientAndReminder {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input the divisor and dividend
        System.out.print("Enter the dividend: ");
        int dividend = input.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = input.nextInt();

        // Find the quotient and remainder
        // using the findRemainderAndQuotient method
        int[] result = findRemainderAndQuotient(dividend, divisor);

        // Output the result
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);

        // Close the scanner
        input.close();
    }

    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        // Calculate quotient and remainder
        int quotient = number / divisor;
        int remainder = number % divisor;

        // Return the results as an array
        return new int[] { quotient, remainder };
    }

}