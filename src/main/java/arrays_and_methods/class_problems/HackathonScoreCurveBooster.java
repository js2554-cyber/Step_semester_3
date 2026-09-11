package arrays_and_methods.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 5 Category C Practice Problem — Problem 1: Hackathon Score Curve Booster
 *
 * Problem Statement:
 * The judging panel at a campus hackathon realizes the coding round was tougher than intended,
 * and wants to give every team a flat bonus before the final leaderboard is printed. Write a
 * method that boosts every score in place — no new array, no return value needed — and print
 * the result using the standard library's own formatting helper.
 *
 * Requirements:
 * - curveScores(...) must modify the caller's original array directly — it should return nothing at all.
 * - Use Arrays.toString(...) to print the final leaderboard, rather than looping and printing manually.
 *
 * Constraints:
 * - scores.length up to 200.
 * - bonus is a non-negative integer.
 */
public class HackathonScoreCurveBooster {

    /**
     * Boosts every score in place by adding the flat bonus amount directly to the caller's array.
     *
     * @param scores the original array of team scores (modified directly in place)
     * @param bonus  the non-negative bonus score to add to each element
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Hackathon Score Curve Booster ===");

        // Sample Test Case from PDF
        int[] scores1 = {70, 85, 60};
        int bonus1 = 10;
        System.out.println("Before curve: " + Arrays.toString(scores1));
        System.out.println("Applying bonus: " + bonus1);
        curveScores(scores1, bonus1);
        System.out.println("After curve:  " + Arrays.toString(scores1));
        System.out.println("Expected:     [80, 95, 70]");

        // Additional Edge Case: bonus is 0
        int[] scores2 = {50, 95};
        System.out.println("\nBefore curve: " + Arrays.toString(scores2));
        curveScores(scores2, 0);
        System.out.println("After curve (bonus 0): " + Arrays.toString(scores2));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of teams: ");
            int n = scanner.nextInt();
            int[] scores = new int[n];
            System.out.println("Enter " + n + " scores:");
            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextInt();
            }
            System.out.print("Enter bonus: ");
            int bonus = scanner.nextInt();
            curveScores(scores, bonus);
            System.out.println("Updated Leaderboard: " + Arrays.toString(scores));
            scanner.close();
        }
    }
}
