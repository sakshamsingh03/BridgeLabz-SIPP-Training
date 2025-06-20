import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        int choice = getChoice();
        double num1 = getInput("Enter first number: ");
        double num2 = getInput("Enter second number: ");

        switch (choice) {
            case 1:
                System.out.println("Result: " + add(num1, num2));
                break;
            case 2:
                System.out.println("Result: " + subtract(num1, num2));
                break;
            case 3:
                System.out.println("Result: " + multiply(num1, num2));
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero!");
                } else {
                    System.out.println("Result: " + divide(num1, num2));
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Basic Calculator");
        System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
        System.out.print("Choose operation (1-4): ");
        return scanner.nextInt();
    }

    public static double getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextDouble();
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}
