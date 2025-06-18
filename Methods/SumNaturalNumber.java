import java.util.Scanner;

public class SumNaturalNumber {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input a natural number
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        // Calculate the sum of natural numbers
        int sum = sumNaturalNumbers(n);

        // Output the result
        System.out.println("The sum of natural numbers up to " + n + " is: " + sum);

        // Close the scanner
        input.close();
    }

    // Method to calculate the sum of natural numbers up to n
    public static int sumNaturalNumbers(int n) {
        // Initialize sum
        int sum = 0;

        // Loop from 1 to n and calculate the sum
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        // Return the calculated sum
        return sum;
    }

}
