import java.util.Scanner;

public class NumberFormatException {

    // Method that generates NumberFormatException (unhandled)
    public static void generateException(String input) {
        // This will throw NumberFormatException if input is not a valid integer
        int number = Integer.parseInt(input);
        System.out.println("Parsed number: " + number);  // Only prints if no exception occurs
    }

    // Method that handles NumberFormatException using try-catch
    public static void handleException(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Parsed number in handled method: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Input is not a valid number.");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take string input
        System.out.print("Enter a number as text: ");
        String input = scanner.nextLine();

        // Call method that generates exception (handled to prevent crash)
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception in generateException: " + e.getMessage());
        }

        // Call method that handles the exception properly
        handleException(input);
    }
}