package arrays_and_methods.assigment_problems;

import java.util.Scanner;

/**
 * Week 5 Category C Assignment Problem — Problem 4: Match Day Grid Analyzer
 *
 * Problem Statement:
 * A cricket stats app logs runs scored in every over of every match as a grid — one row per
 * match, one column per over. The app wants to flag which matches were genuine "Power Surge"
 * innings (a high scoring rate throughout) without repeating the same averaging code once per match.
 *
 * Requirements:
 * - Write a helper, rowAverage(int[] row), and call it once per match from the main method — do
 *   not recompute an average inline more than once.
 * - A match averaging at or above the threshold is a "Power Surge"; below it, "Normal".
 * - Matches may have a different number of overs recorded — do not assume every row has the same length.
 *
 * Function Signature(s):
 * - static double rowAverage(int[] row)
 * - static String classifyMatches(int[][] runsPerOver, int threshold)
 */
public class MatchDayGridAnalyzer {

    /**
     * Computes the average runs scored per over for a single match row.
     * Reusable helper method to avoid duplicating the averaging calculation.
     *
     * @param row an array of runs scored in each over of the match
     * @return the average runs per over as a double, or 0.0 if row is null/empty
     */
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    /**
     * Classifies matches as "Power Surge" or "Normal" based on whether their run rate meets or
     * exceeds the threshold.
     *
     * @param runsPerOver 2D jagged array of runs scored per over across matches
     * @param threshold   cutoff scoring rate for a Power Surge
     * @return formatted string classification for each match
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Match ").append(i).append(": ").append(status);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Match Day Grid Analyzer ===");

        // Sample Test Case from PDF
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println("Threshold: " + threshold);
        String result = classifyMatches(runs, threshold);
        System.out.println("Output:   " + result);
        System.out.println("Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal");

        // Jagged Match Data (T20 vs ODI overs)
        int[][] jaggedRuns = {
            {6, 12, 18, 24},
            {1, 2}
        };
        System.out.println("\nJagged Runs test with threshold 10:");
        System.out.println("Output: " + classifyMatches(jaggedRuns, 10));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of matches: ");
            int m = scanner.nextInt();
            int[][] customRuns = new int[m][];
            for (int i = 0; i < m; i++) {
                System.out.print("Enter number of overs for match " + i + ": ");
                int overs = scanner.nextInt();
                customRuns[i] = new int[overs];
                System.out.println("Enter " + overs + " over scores:");
                for (int j = 0; j < overs; j++) {
                    customRuns[i][j] = scanner.nextInt();
                }
            }
            System.out.print("Enter Power Surge threshold: ");
            int th = scanner.nextInt();
            System.out.println("Result: " + classifyMatches(customRuns, th));
            scanner.close();
        }
    }
}
