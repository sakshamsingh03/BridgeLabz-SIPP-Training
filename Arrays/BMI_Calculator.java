import java.util.Scanner;

public class BMI_Calculator {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Get the number of persons
        System.out.print("Enter the number of persons: ");
        int number = input.nextInt();

        // Create a multi-dimensional array to store weight, height, and BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input weight and height for each person
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            double weight = input.nextDouble();
            while (weight <= 0) {
                System.out.print("Please enter a positive weight: ");
                weight = input.nextDouble();
            }

            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            double height = input.nextDouble();
            while (height <= 0) {
                System.out.print("Please enter a positive height: ");
                height = input.nextDouble();
            }

            // Calculate BMI
            double bmi = weight / (height * height);
            personData[i][0] = weight; // Store weight
            personData[i][1] = height; // Store height
            personData[i][2] = bmi; // Store BMI

            // Determine weight status
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        // Display the results
        System.out.println("\nPerson Data:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("Height: " + personData[i][1] + " m");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Weight Status: " + weightStatus[i]);
            System.out.println();
        }

        // Close the input stream
        input.close();
    }
}