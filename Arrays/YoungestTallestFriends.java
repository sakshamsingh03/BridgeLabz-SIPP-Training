import java.util.Scanner;

public class YoungestTallestFriends {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Create arrays to store ages and heights of the friends
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input ages and heights for the 3 friends
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of friend " + (i + 1) + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height of friend " + (i + 1) + " (in cm): ");
            heights[i] = input.nextDouble();
        }

        // Initialize variables to find the youngest and tallest
        int youngestIndex = 0;
        int tallestIndex = 0;

        // Loop through the arrays to find the youngest and tallest
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display the results
        System.out.println("Youngest Friend: Friend " + (youngestIndex + 1) + " with age " + ages[youngestIndex]);
        System.out.println(
                "Tallest Friend: Friend " + (tallestIndex + 1) + " with height " + heights[tallestIndex] + " cm");

        // Close the input stream
        input.close();
    }
}