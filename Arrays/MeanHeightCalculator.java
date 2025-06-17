import java.util.Scanner;

class MeanHeightCalculator {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Create a double array to store the heights of 11 players
        double[] heights = new double[11];

        // Take user input for the heights of the players
        System.out.println("Please enter the heights of 11 players in meters:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height for player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
        }

        // Calculate the sum of all heights
        double sum = 0;
        for (double height : heights) {
            sum += height;
        }

        // Calculate the mean height
        double meanHeight = sum / heights.length;

        // Display the mean height
        System.out.printf("The mean height of the football team is: %.2f meters%n", meanHeight);

        // Close the input stream
        input.close();
    }
}