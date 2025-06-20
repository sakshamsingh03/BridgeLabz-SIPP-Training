import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = getChoice();

        double temperature = getInput("Enter the temperature: ");

        if (choice == 1) {
            double celsius = toCelsius(temperature);
            System.out.println(temperature + "°F = " + celsius + "°C");
        } else if (choice == 2) {
            double fahrenheit = toFahrenheit(temperature);
            System.out.println(temperature + "°C = " + fahrenheit + "°F");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose conversion type (1 or 2): ");
        return scanner.nextInt();
    }

    public static double getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double toFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
