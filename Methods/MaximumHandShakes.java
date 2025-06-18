import java.util.Scanner;

public class MaximumHandShakes {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int n = input.nextInt();

        // Calculate the maximum number of handshakes
        int maxHandshakes = calculateMaxHandshakes(n);

        // Output the result
        System.out.println("The maximum number of handshakes is: " + maxHandshakes);

        // Close the scanner
        input.close();
    }

    // Method to calculate the maximum number of handshakes
    public static int calculateMaxHandshakes(int n) {
        // The formula for maximum handshakes is (n * (n - 1)) / 2
        return (n * (n - 1)) / 2;
    }
}
