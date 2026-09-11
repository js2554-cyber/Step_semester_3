package arrays_and_methods.class_problems;

import java.util.Scanner;

/**
 * Week 5 Category C Practice Problem — Problem 4: Hackathon Seating Grid Optimizer
 *
 * Problem Statement:
 * The venue is arranged as a grid of seating rows, and organizers want to walk the
 * floor toward the rows where teams are visibly struggling (to offer mentor help) versus
 * the rows that are humming along fine. Classify every row using one small, reusable
 * helper method rather than repeating the averaging logic for each row by hand.
 *
 * Requirements:
 * - Write a private/package helper, rowAverage(int[] row), and call it once per row from
 *   the main method — do not recompute an average inline more than once.
 * - A row averaging below the threshold is a "Quiet Zone"; at or above it, a "Buzzing Zone".
 * - Rows may vary in length (a jagged grid) — do not assume every row has the same number of columns.
 *
 * Function Signature(s):
 * - static double rowAverage(int[] row)
 * - static String classifyRows(int[][] seatingScores, int threshold)
 */
public class HackathonSeatingGridOptimizer {

    /**
     * Computes the average score for a single seating row.
     * Reusable helper method designed to prevent duplicate averaging logic.
     * Handles jagged rows where lengths may vary.
     *
     * @param row an array representing scores in one seating row
     * @return the average score as a double, or 0.0 if the row is null/empty
     */
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    /**
     * Classifies each row in the seating grid as "Quiet Zone" or "Buzzing Zone"
     * based on whether its average meets or exceeds the threshold.
     *
     * @param seatingScores 2D array representing seating rows and scores
     * @param threshold     the cutoff score between Quiet Zone and Buzzing Zone
     * @return formatted string report of row classifications
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Row ").append(i).append(": ").append(zone);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Hackathon Seating Grid Optimizer ===");

        // Sample Test Case from PDF
        int[][] seatingScores1 = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold1 = 60;
        System.out.println("Threshold: " + threshold1);
        String result1 = classifyRows(seatingScores1, threshold1);
        System.out.println("Output:   " + result1);
        System.out.println("Expected: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone");

        // Additional Test Case: Jagged grid
        int[][] jaggedGrid = {
            {50, 70},
            {90, 80, 85, 95},
            {30}
        };
        System.out.println("\nJagged Grid with threshold 65:");
        System.out.println("Output: " + classifyRows(jaggedGrid, 65));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of rows: ");
            int rows = scanner.nextInt();
            int[][] grid = new int[rows][];
            for (int r = 0; r < rows; r++) {
                System.out.print("Enter number of scores in row " + r + ": ");
                int cols = scanner.nextInt();
                grid[r] = new int[cols];
                System.out.println("Enter " + cols + " scores:");
                for (int c = 0; c < cols; c++) {
                    grid[r][c] = scanner.nextInt();
                }
            }
            System.out.print("Enter threshold: ");
            int th = scanner.nextInt();
            System.out.println("Classification: " + classifyRows(grid, th));
            scanner.close();
        }
    }
}
