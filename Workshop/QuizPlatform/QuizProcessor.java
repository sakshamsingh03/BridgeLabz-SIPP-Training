import java.util.ArrayList;
import java.util.List;

public class QuizProcessor {
    private String[] correctAnswers;
    private List<Integer> scores;

    public QuizProcessor(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
        this.scores = new ArrayList<>();
    }

    public int calculateScore(String[] userAnswers) throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Mismatch in number of answers submitted.");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                score++;
            }
        }

        scores.add(score);  // Store the user score
        return score;
    }

    public String getGrade(int score) {
        if (score == correctAnswers.length) return "A+";
        if (score >= correctAnswers.length * 0.8) return "A";
        if (score >= correctAnswers.length * 0.6) return "B";
        if (score >= correctAnswers.length * 0.4) return "C";
        return "Fail";
    }

    public List<Integer> getAllScores() {
        return scores;
    }
}