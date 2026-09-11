package arrays_and_methods.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 5 Category C Assignment Problem — Problem 3: Top Performer Tracker
 *
 * Problem Statement:
 * A fantasy league's weekly recap wants to instantly call out the week's standout performer
 * and the week's biggest disappointment, along with how wide the gap between them was — without
 * sorting the entire scoreboard just to read off two numbers.
 *
 * Requirements:
 * - Do not sort the array — find the minimum and maximum in a single pass through the array.
 * - Report the minimum, the maximum, and the spread (max - min) together.
 *
 * Constraints:
 * - scores.length is at least 2, up to 10,000.
 */
public class TopPerformerTracker {

    /**
     * Finds the minimum score, maximum score, and score spread in a single pass.
     * Avoids sorting the array, running in O(N) time and O(1) space.
     *
     * @param scores array of player scores (length >= 2)
     * @return formatted string report: "Min: <min> | Max: <max> | Spread: <spread>"
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            throw new IllegalArgumentException("Scores array must contain at least 2 elements.");
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Top Performer Tracker ===");

        // Sample Test Case from PDF
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Scores:   " + Arrays.toString(scores1));
        String result1 = findMinMaxSpread(scores1);
        System.out.println("Output:   " + result1);
        System.out.println("Expected: Min: 33 | Max: 90 | Spread: 57");

        // Additional Test Case: Negative and positive numbers
        int[] scores2 = {-10, 0, 25, 40};
        System.out.println("\nScores:   " + Arrays.toString(scores2));
        System.out.println("Output:   " + findMinMaxSpread(scores2));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of players (>= 2): ");
            int n = scanner.nextInt();
            int[] customScores = new int[n];
            System.out.println("Enter " + n + " scores:");
            for (int i = 0; i < n; i++) {
                customScores[i] = scanner.nextInt();
            }
            System.out.println("Recap: " + findMinMaxSpread(customScores));
            scanner.close();
        }
    }
}
