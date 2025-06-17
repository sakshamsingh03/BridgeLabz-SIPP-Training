import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input for a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Count the number of digits in the number
        int count = 0;
        int temp = number;
        while (temp > 0) {
            temp /= 10;
            count++;
        }

        // Create an array to store the digits
        int[] digits = new int[count];
        temp = number;

        // Save the digits in the array
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Display the digits in reverse order
        System.out.println("Reversed Number:");
        for (int digit : digits) {
            System.out.print(digit);
        }

        // Close the input stream
        input.close();
    }
}