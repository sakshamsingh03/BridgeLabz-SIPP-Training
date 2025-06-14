import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get weight input in pounds
        System.out.print("Enter weight in pounds: ");
        double pounds = sc.nextDouble();
        
        // Convert to kilograms (1 pound = 0.453592 kg)
        double kilograms = pounds / 2.2;
        
        // Display results
        System.out.printf("The weight of the person in pounds is %.2f and in kg is %.2f", 
                         pounds, kilograms);
        
    }
}