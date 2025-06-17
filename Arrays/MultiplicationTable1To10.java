import java.util.Scanner;

public class MultiplicationTable1To10 {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Get an integer input from the user
        System.out.print("Enter a number to print its multiplication table: ");
        int number = input.nextInt();

        // Define an array to store multiplication results
        int[] multiplicationTable = new int[10];

        // Calculate multiplication results and store them in the array
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the multiplication table
        System.out.println("Multiplication Table of " + number + ":");
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }

        // Close the input stream
        input.close();
    }
}