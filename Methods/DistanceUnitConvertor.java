import java.util.Scanner;

public class DistanceUnitConvertor {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a distance in kilometers
        System.out.print("Enter distance in kilometers: ");
        double kilometers = input.nextDouble();

        // Convert kilometers to miles
        double miles = convertKilometersToMiles(kilometers);

        // Convert miles to kilometers
        double kilometersConvertedBack = convertMilesToKilometers(miles);

        // Convert meters to feet
        double meters = convertMeterToFeet(kilometers * 1000);

        // Convert feet to meters
        double feet = convertFeetToMeters(meters);

        // Display the result
        System.out.printf("%.2f kilometers is equal to %.2f miles.%n", kilometers, miles);
        System.out.printf("%.2f miles is equal to %.2f kilometers.%n", miles, kilometersConvertedBack);
        System.out.printf("%.2f meters is equal to %.2f feet.%n", kilometers * 1000, meters);
        System.out.printf("%.2f feet is equal to %.2f meters.%n", meters, feet);

        // Close the scanner
        input.close();
    }

    // Method to convert kilometers to miles
    public static double convertKilometersToMiles(double km) {
        double kmToMiles = 0.621371;
        return km * kmToMiles;
    }

    // Method to convert miles to kilometers
    public static double convertMilesToKilometers(double miles) {
        double milesToKm = 1.60934;
        return miles * milesToKm;
    }

    // Method to convert meters to feet
    public static double convertMeterToFeet(double meters) {
        double metersToFeet = 3.28084;
        return meters * metersToFeet;
    }

    // Method to convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double feetToMeters = 0.3048;
        return feet * feetToMeters;
    }
}
