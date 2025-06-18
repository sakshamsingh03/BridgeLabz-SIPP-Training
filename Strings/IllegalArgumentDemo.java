import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method that generates IllegalArgumentException without handling
    public static void generateException(String input) {
        
        String result = input.substring(5, 2);
        System.out.println("Substring: " + result);
    }

    // Method that handles the exception using try-catch block
    public static void handleException(String input) {
        try {
            // Again, deliberately causing IllegalArgumentException
            String result = input.substring(5, 2);
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: Start index is greater than end index.");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // This will cause the program to terminate if not handled
        try {
            generateException(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception in generateException: " + e.getMessage());
        }

        // This method handles the exception properly
        handleException(userInput);
    }
}