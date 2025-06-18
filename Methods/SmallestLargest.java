import java.util.Scanner;

public class SmallestLargest {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input three numbers
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        System.out.print("Enter the third number: ");
        int number3 = input.nextInt();

        // Find smallest and largest numbers
        int[] result = findSmallestAndLargest(number1, number2, number3);

        // Output the result
        System.out.println("The smallest number is: " + result[0]);
        System.out.println("The largest number is: " + result[1]);

        // Close the scanner
        input.close();
    }

    // Method to find smallest and largest of three numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        // Find the smallest number
        int smallest = Math.min(Math.min(number1, number2), number3);

        // Find the largest number
        int largest = Math.max(Math.max(number1, number2), number3);

        // Return the results as an array
        return new int[] { smallest, largest };
    }
}