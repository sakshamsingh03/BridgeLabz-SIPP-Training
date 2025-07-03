import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] correctAnswers = {"A", "B", "C", "D", "A"};
        QuizProcessor qp = new QuizProcessor(correctAnswers);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your answers (5 questions, choices A/B/C/D):");
        String[] userAnswers = new String[correctAnswers.length];

        for (int i = 0; i < correctAnswers.length; i++) {
            System.out.print("Q" + (i + 1) + ": ");
            userAnswers[i] = scanner.nextLine().trim().toUpperCase();
        }

        try {
            int score = qp.calculateScore(userAnswers);
            String grade = qp.getGrade(score);
            System.out.println("\nScore: " + score + "/" + correctAnswers.length);
            System.out.println("Grade: " + grade);
        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}