import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for the number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons = sc.nextInt();

        // Create arrays to store weight, height, BMI, and weight status
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];

        // Take input for weight and height of each person
        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weights[i] = sc.nextDouble();
            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < numPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] <= 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obesity";
            }
        }

        // Display the results
        System.out.println("\nBMI Results:");
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("Weight: " + weights[i] + " kg");
            System.out.println("Height: " + heights[i] + " m");
            System.out.println("BMI: " + bmis[i]);
            System.out.println("Weight Status: " + statuses[i]);
        }
        sc.close();
    }
}