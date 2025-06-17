import java.util.Scanner;

class FizzBuzz {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Get user input for the number
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Validate input
        if (number < 0) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return;
        }

        // Create a String array to store results
        String[] results = new String[number + 1];

        // Loop from 1 to the number and fill the array
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        // Display the results
        for (int i = 1; i < results.length; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        // Close the input stream
        input.close();
    }
}