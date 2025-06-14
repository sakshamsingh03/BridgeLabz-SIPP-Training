import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Principal amount: ");
        double principal = sc.nextDouble();
        
        System.out.print("Rate of Interest (in %): ");
        double rate = sc.nextDouble();
        
        System.out.print("Time period (in years): ");
        double time = sc.nextDouble();
        
        // Calculate simple interest
        double simpleInterest = (principal * rate * time) / 100;
        
        // Display results
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f%% and Time %.2f years",
                          simpleInterest, principal, rate, time);
    }
}