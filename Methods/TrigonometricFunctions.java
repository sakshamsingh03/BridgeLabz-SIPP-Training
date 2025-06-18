import java.util.Scanner;
public class TrigonometricFunctions {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input the angle in degrees
        System.out.print("Enter an angle in degrees: ");
        double angle = input.nextDouble();
        
        // Calculate sine, cosine, and tangent
        // using the calculateTrigonometricFunctions method
        double[] results = calculateTrigonometricFunctions(angle);
        
        // Output the results
        System.out.println("Trigonometric Functions for " + angle + " degrees:");
        System.out.printf("Sine: %.4f%n", results[0]);
        System.out.printf("Cosine: %.4f%n", results[1]);
        System.out.printf("Tangent: %.4f%n", results[2]);
        
        // Close the scanner
        input.close();
    }

    // Method to calculate sine, cosine, and tangent of an angle in degrees
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert angle from degrees to radians and calculate sine, cosine, and tangent
        // using Math.sin, Math.cos, and Math.tan methods
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        
        // Return the results as an array
        return new double[]{sine, cosine, tangent};
    }
}