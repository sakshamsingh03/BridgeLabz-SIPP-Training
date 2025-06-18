import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input sides of the triangle
        System.out.print("Enter the length of side A (in meters): ");
        double sideA = input.nextDouble();

        System.out.print("Enter the length of side B (in meters): ");
        double sideB = input.nextDouble();

        System.out.print("Enter the length of side C (in meters): ");
        double sideC = input.nextDouble();

        // Calculate the perimeter
        double perimeter = calculatePerimeter(sideA, sideB, sideC);

        // Calculate the number of rounds needed to complete a 5 km run
        double rounds = calculateRounds(perimeter, 5000);

        // Output the result
        System.out.println("The athlete needs to complete " + rounds + " rounds to finish a 5 km run.");

        // Close the scanner
        input.close();
    }

    // Methods to calculate perimeter
    public static double calculatePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    // Method to calculate the number of rounds needed
    public static double calculateRounds(double perimeter, double distance) {
        return distance / perimeter;
    }
}