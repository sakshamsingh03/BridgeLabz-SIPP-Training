import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input a number from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Method to check if the number is positive, negative, or zero
        String result = checkNumber(number);

        // Output the result
        System.out.println("The number " + number + " is " + result + ".");

        // Close the scanner
        input.close();
    }

    // Method to check if the number is positive, negative, or zero
    public static String checkNumber(int number) {
        // Check the number and return the appropriate string
        if (number > 0) {
            return "positive";
        } else if (number < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }
}
