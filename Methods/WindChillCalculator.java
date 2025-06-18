import java.util.Scanner;

public class WindChillCalculator {

    public static void main(String[] args) {
        // create a Scanner object
        Scanner input = new Scanner(System.in);

        // Get temperature input from user
        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = input.nextDouble();
        // Get wind speed input from user
        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = input.nextDouble();

        // Create an instance of WindChillCalculator and calculate wind chill
        WindChillCalculator calculator = new WindChillCalculator();
        double windChill = calculator.calculateWindChill(temperature, windSpeed);

        // Display the result
        System.out.printf("The wind chill temperature is: %.2f°F", windChill);

        // Close the input stream
        input.close();
    }

    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + (0.6215 * temperature) + ((0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16));
    }
}