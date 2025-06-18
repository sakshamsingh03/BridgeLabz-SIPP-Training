import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input the Principal, Rate, and Time values
        System.out.print("Enter the principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the rate of interest (in %): ");
        double rate = input.nextDouble();

        System.out.print("Enter the time period (in years): ");
        int time = input.nextInt();

        // Calculate simple interest
        double interest = calculateSimpleInterest(principal, rate, time);

        // Output the result
        System.out.println("The simple interest is: " + interest);
    }

    // Method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, int time) {
        return (principal * rate * time) / 100;
    }
}
