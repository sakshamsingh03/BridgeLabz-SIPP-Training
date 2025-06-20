import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it. Respond with 'high', 'low', or 'correct'.");

        int lowerBound = 1;
        int upperBound = 100;
        boolean found = false;

        while (!found && lowerBound <= upperBound) {
            int guess = generateGuess(lowerBound, upperBound);
            System.out.println("Is your number " + guess + "?");

            String feedback = getUserFeedback();

            switch (feedback.toLowerCase()) {
                case "correct":
                    System.out.println("Yay! I guessed your number correctly!");
                    found = true;
                    break;
                case "low":
                    lowerBound = updateBounds(lowerBound, guess + 1, true);
                    break;
                case "high":
                    upperBound = updateBounds(upperBound, guess - 1, false);
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }

        if (!found) {
            System.out.println("Hmm... seems like something went wrong with the feedback.");
        }
    }

    // Generate a random guess between lower and upper bounds
    public static int generateGuess(int lower, int upper) {
        return lower + random.nextInt(upper - lower + 1);
    }

    // Get user feedback from console
    public static String getUserFeedback() {
        System.out.print("Enter your feedback: ");
        return scanner.nextLine();
    }

    // Update the lower or upper bound based on guess and feedback
    public static int updateBounds(int current, int newBound, boolean isLower) {
        if (isLower) {
            return Math.max(current, newBound);  // move lower bound up
        } else {
            return Math.min(current, newBound);  // move upper bound down
        }
    }
}
