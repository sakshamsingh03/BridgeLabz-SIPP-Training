import java.util.Scanner;
public class RockPaperScissors {
    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 1.0 / 3) return "rock";
        else if (rand < 2.0 / 3) return "paper";
        else return "scissors";
    }

    // 2. Determine winner
    public static String getWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static String[][] playGame(int rounds, Scanner scanner) {
        String[][] results = new String[rounds + 2][4]; 
        int userWins = 0, computerWins = 0, draws = 0;
        results[0][0] = "Game";
        results[0][1] = "User";
        results[0][2] = "Computer";
        results[0][3] = "Winner";

        for (int i = 1; i <= rounds; i++) {
            System.out.print("Game " + i + " - Enter your choice (rock/paper/scissors): ");
            String user = scanner.next().toLowerCase();
            String computer = getComputerChoice();
            String winner = getWinner(user, computer);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;

            results[i][0] = "Game " + i;
            results[i][1] = user;
            results[i][2] = computer;
            results[i][3] = winner;
        }

        // Calculate and add summary
        results[rounds + 1][0] = "TOTAL";
        results[rounds + 1][1] = "Wins: " + userWins + " (" + ((userWins * 100) / rounds) + "%)";
        results[rounds + 1][2] = "Wins: " + computerWins + " (" + ((computerWins * 100) / rounds) + "%)";
        results[rounds + 1][3] = "Draws: " + draws;

        return results;
    }

    public static void displayResults(String[][] results) {
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Game", "User", "Computer", "Winner");
        System.out.println("-----------------------------------------------------");

        for (int i = 1; i < results.length; i++) {
            if (results[i][0] == null) break;
            System.out.printf("%-10s | %-10s | %-10s | %-10s\n",
                    results[i][0], results[i][1], results[i][2], results[i][3]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int games = scanner.nextInt();
        String[][] results = playGame(games, scanner);
        System.out.println("\n--- Game Results ---");
        displayResults(results);
    }
}