import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Take the number as input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Create an array to store the digits of the number
        int[] digits = new int[10];
        int temp = number;

        // Count the digits and store them in the array
        while (temp > 0) {
            int digit = temp % 10;
            digits[digit]++;
            temp /= 10;
        }

        // Display the frequency of each digit
        System.out.println("Digit Frequency:");
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 0) {
                System.out.println("Digit " + i + ": " + digits[i] + " time(s)");
            }
        }

        // Close the input stream
        input.close();
    }
}