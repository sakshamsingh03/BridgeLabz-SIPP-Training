public class UnitConverterF2C {

    // 1. Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // 2. Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // 3. Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    // 4. Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // 5. Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // 6. Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    // Optional: main method to test the conversions
    public static void main(String[] args) {
        System.out.println("Fahrenheit to Celsius (98.6°F): " + convertFahrenheitToCelsius(98.6));
        System.out.println("Celsius to Fahrenheit (37°C): " + convertCelsiusToFahrenheit(37));
        System.out.println("Pounds to Kilograms (150 lbs): " + convertPoundsToKilograms(150));
        System.out.println("Kilograms to Pounds (68 kg): " + convertKilogramsToPounds(68));
        System.out.println("Gallons to Liters (5 gal): " + convertGallonsToLiters(5));
        System.out.println("Liters to Gallons (10 L): " + convertLitersToGallons(10));
    }
}
