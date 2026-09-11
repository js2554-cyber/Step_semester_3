package arrays_and_methods.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 5 Category C Assignment Problem — Problem 1: Fantasy Team Score Multiplier
 *
 * Problem Statement:
 * In a fantasy sports app, every user picks a Captain (2x points) and a Vice-Captain (1.5x points)
 * from their lineup. Write a method that applies both multipliers directly to the lineup's
 * score array, so the app's scoreboard reflects the boosted totals immediately after the match end.
 *
 * Requirements:
 * - applyMultipliers(...) must modify the caller's original array directly — it should return nothing at all.
 * - Only the captain's and vice-captain's positions change; every other score stays exactly as it was.
 *
 * Constraints:
 * - playerScores.length up to 15.
 * - captainIndex and viceCaptainIndex are always valid, distinct indices.
 */
public class FantasyTeamScoreMultiplier {

    /**
     * Applies multipliers directly to the player scores array in place.
     * Captain receives a 2.0x boost, while Vice-Captain receives a 1.5x boost.
     *
     * @param playerScores      array of player scores (modified directly in place)
     * @param captainIndex      valid index of the selected captain (multiplied by 2.0)
     * @param viceCaptainIndex  valid index of the selected vice-captain (multiplied by 1.5)
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }

        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }

        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Fantasy Team Score Multiplier ===");

        // Sample Test Case from PDF
        double[] scores1 = {40, 55, 30, 62};
        int cap1 = 1;
        int viceCap1 = 3;
        System.out.println("Initial Scores: " + Arrays.toString(scores1));
        System.out.println("Captain Index: " + cap1 + " (2x), Vice-Captain Index: " + viceCap1 + " (1.5x)");
        applyMultipliers(scores1, cap1, viceCap1);
        System.out.println("Boosted Scores: " + Arrays.toString(scores1));
        System.out.println("Expected:       [40.0, 110.0, 30.0, 93.0]");

        // Additional Test Case
        double[] scores2 = {10.0, 20.0, 30.0};
        applyMultipliers(scores2, 0, 2);
        System.out.println("\nScores after Captain at 0 and VC at 2: " + Arrays.toString(scores2));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of players: ");
            int n = scanner.nextInt();
            double[] scores = new double[n];
            System.out.println("Enter " + n + " scores:");
            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextDouble();
            }
            System.out.print("Enter captain index (0-based): ");
            int cap = scanner.nextInt();
            System.out.print("Enter vice-captain index (0-based): ");
            int vc = scanner.nextInt();
            applyMultipliers(scores, cap, vc);
            System.out.println("Final Scores: " + Arrays.toString(scores));
            scanner.close();
        }
    }
}
