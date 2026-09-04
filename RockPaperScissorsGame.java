import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * Day 1 Live-Coding Session — Problem 1: Rock-Paper-Scissors Game
 *
 * Scenario:
 * The College Coding Arcade
 * The coding club is setting up a mini arcade module for orientation day, where new
 * students play a quick Rock-Paper-Scissors match against the computer as a warm-up
 * before their placement round. The club needs a simulator that plays several rounds
 * between the "player" and the "computer," records the outcome of every round, and
 * prints a final scoreboard summarizing wins, losses, draws, and the player's win percentage.
 *
 * Concepts covered: Random number generation, conditional logic, loops, arrays for the round table,
 * formatted/tabular output, basic statistics (percentage calculation).
 */
public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the result of a single Rock-Paper-Scissors round.
     *
     * @param playerMove move played by the player ("Rock", "Paper", or "Scissors")
     * @param computerMove move played by the computer ("Rock", "Paper", or "Scissors")
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }

        String p = playerMove.trim();
        String c = computerMove.trim();

        if (p.equalsIgnoreCase(c)) {
            return "Draw";
        }

        if ((p.equalsIgnoreCase("Rock") && c.equalsIgnoreCase("Scissors")) ||
            (p.equalsIgnoreCase("Scissors") && c.equalsIgnoreCase("Paper")) ||
            (p.equalsIgnoreCase("Paper") && c.equalsIgnoreCase("Rock"))) {
            return "Player Wins";
        } else if ((c.equalsIgnoreCase("Rock") && p.equalsIgnoreCase("Scissors")) ||
                   (c.equalsIgnoreCase("Scissors") && p.equalsIgnoreCase("Paper")) ||
                   (c.equalsIgnoreCase("Paper") && p.equalsIgnoreCase("Rock"))) {
            return "Computer Wins";
        } else {
            return "Invalid Move";
        }
    }

    /**
     * Generates a random computer move ("Rock", "Paper", or "Scissors").
     */
    public static String getRandomComputerMove(Random random) {
        return MOVES[random.nextInt(MOVES.length)];
    }

    /**
     * Simulates N rounds using predefined player moves and random computer moves,
     * or predefined moves for demonstration.
     */
    public static void runGameSimulation(String[] playerMoves, String[] computerMoves) {
        int rounds = playerMoves.length;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] results = new String[rounds];

        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-7s | %-12s | %-14s | %-13s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            String pMove = playerMoves[i];
            String cMove = computerMoves[i];
            String result = playRound(pMove, cMove);
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else if (result.equals("Draw")) {
                draws++;
            }

            System.out.printf("Round %-2d | %-12s | %-14s | %-13s%n", (i + 1), pMove, cMove, result);
        }
        System.out.println("------------------------------------------------------------------");

        double winPercentage = (rounds == 0) ? 0.0 : ((double) wins / rounds) * 100.0;
        System.out.printf(Locale.US, "Final Summary (after %d rounds):%nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                rounds, wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Rock-Paper-Scissors Game ===");

        // Predefined demo matching the PDF sample requirements (5 rounds)
        System.out.println("\n[Demo: 5-Round Match]");
        String[] samplePlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] sampleComputerMoves = {"Scissors", "Paper", "Rock", "Paper", "Rock"};

        runGameSimulation(samplePlayerMoves, sampleComputerMoves);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int n = 5;
            String[] userMoves = new String[n];
            String[] compMoves = new String[n];

            System.out.println("\n--- Interactive Game (5 Rounds) ---");
            for (int i = 0; i < n; i++) {
                System.out.print("Round " + (i + 1) + " - Enter your move (Rock, Paper, Scissors): ");
                userMoves[i] = scanner.nextLine().trim();
                compMoves[i] = getRandomComputerMove(random);
                System.out.println("Computer chose: " + compMoves[i]);
                System.out.println("Result: " + playRound(userMoves[i], compMoves[i]));
            }

            System.out.println("\n--- Final Game Summary ---");
            runGameSimulation(userMoves, compMoves);
            scanner.close();
        }
    }
}
