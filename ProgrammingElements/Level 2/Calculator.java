import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        double num1, num2;

        System.out.print("1st number: ");
        num1 = input.nextDouble(); // Take first input

        System.out.print("Second number: ");
        num2 = input.nextDouble(); // Take second input

        // Perform arithmetic operations
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num2 != 0 ? num1 / num2 : Double.NaN; // Handle divide by zero

      
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "
            + num1 + " and " + num2 + " is " + sum + ", " + difference + ", " + product + " and " 
            + (num2 != 0 ? quotient : "Undefined (division by zero)"));
    }
}
