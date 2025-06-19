import java.util.Scanner;
import java.util.Random;

public class VotingEligibilityChecker {

    // 1. Method to generate random 2-digit ages for n students
    public static int[] generateRandomAges(int n) {
        Random random = new Random();
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(90) + 10; // generates 2-digit number (10 to 99)
        }

        return ages;
    }

    // 2. Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);

            if (age < 0) {
                result[i][1] = "false (Invalid)";
            } else if (age >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    // 3. Method to display 2D array in tabular format
    public static void displayEligibilityTable(String[][] data) {
        System.out.printf("%-10s | %-10s\n", "Age", "Can Vote");
        System.out.println("------------------------");

        for (String[] row : data) {
            System.out.printf("%-10s | %-10s\n", row[0], row[1]);
        }
    }

    // 4. Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for number of students (can hardcode to 10 too)
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // Generate random ages
        int[] studentAges = generateRandomAges(n);

        // Check voting eligibility
        String[][] votingResults = checkVotingEligibility(studentAges);

        // Display the result
        System.out.println("\nVoting Eligibility Table:");
        displayEligibilityTable(votingResults);
    }
}