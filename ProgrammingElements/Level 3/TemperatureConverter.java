import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();
        
        // Convert to Celsius
        double celsius = (fahrenheit - 32) * 5/9;
        
        // Display results
        System.out.printf("The %.2f fahrenheit is %.2f celsius", fahrenheit, celsius);
        
    }
}