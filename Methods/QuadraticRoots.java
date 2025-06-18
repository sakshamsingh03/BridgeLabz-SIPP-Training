import java.util.Scanner;

public class QuadraticRoots {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input coefficients a, b, and c from the user
        System.out.print("Enter coefficients a, b, and c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        // Calculate the roots of the quadratic equation
        double[] roots = findRoots(a, b, c);

        // Display the results
        if (roots == null) {
            System.out.println("The equation has no real roots.");
        } else if (roots.length == 1) {
            System.out.println("The equation has one real root: " + roots[0]);
        } else {
            System.out.println("The equation has two real roots: " + roots[0] + " and " + roots[1]);
        }

        // Close the scanner
        input.close();
    }

    // Method to find the roots of a quadratic equation ax^2 + bx + c = 0
    public static double[] findRoots(double a, double b, double c) {
        // Calculate the discriminant
        double discriminant = Math.pow(b, 2) - 4 * a * c;

        // Check the value of the discriminant
        if (discriminant < 0) {
            return null; // No real roots
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[] { root }; // One real root
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[] { root1, root2 }; // Two real roots
        }
    }
}
