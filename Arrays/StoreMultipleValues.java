import java.util.Scanner;

public class StoreMultipleValues {
    public static void main(String[] args) {
        // Create an array to store up to 10 double values
        double[] numbers = new double[10];
        double total = 0.0; // Variable to store the total
        int index = 0; // Index variable for the array

        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Infinite loop to take user input
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = input.nextDouble();

            // Check if the user entered 0 or a negative number or if the index exceeds the
            // array size
            if (number <= 0 || index >= 10) {
                break;
            }

            // Store the number in the array and increment the index
            numbers[index] = number;
            index++;
        }

        // Calculate the total of the entered numbers
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display all entered numbers and the total
        System.out.println("You entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println("Total: " + total);

        // Close the input stream
        input.close();
    }
}