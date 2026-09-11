package arrays_and_methods.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 5 Category C Practice Problem — Problem 3: Top-3 Podium Finder
 *
 * Problem Statement:
 * With hundreds of teams submitting scores, sorting the entire array just to find the top 3
 * podium finishers is overkill — a judge on stage wants the podium announced the instant scoring
 * wraps up, without waiting for a full sort. Find the top 3 scores in a single pass through the array.
 *
 * Requirements:
 * - Do not sort the array and do not use Arrays.sort(...) — track the top 3 scores as you scan once, left to right.
 * - Return the three scores in descending order.
 *
 * Constraints:
 * - scores.length is at least 3, up to 10,000.
 */
public class TopThreePodiumFinder {

    /**
     * Finds the top 3 scores in a single pass through the array without sorting.
     * Handles ties correctly (e.g., if two teams tie for first place, both occupy podium slots).
     *
     * @param scores array of team scores (length >= 3)
     * @return an int array of length 3 containing the top 3 scores in descending order [first, second, third]
     */
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 scores.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score >= third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Top-3 Podium Finder ===");

        // Sample Test Case from PDF
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Input:    " + Arrays.toString(scores1));
        int[] podium1 = findTopThreeScores(scores1);
        System.out.println("Output:   " + Arrays.toString(podium1));
        System.out.println("Expected: [90, 90, 82]");

        // Additional Test Case: Strictly decreasing
        int[] scores2 = {100, 90, 80, 70};
        System.out.println("\nInput:    " + Arrays.toString(scores2));
        System.out.println("Output:   " + Arrays.toString(findTopThreeScores(scores2)));

        // Additional Test Case: All identical scores
        int[] scores3 = {50, 50, 50, 50};
        System.out.println("\nInput:    " + Arrays.toString(scores3));
        System.out.println("Output:   " + Arrays.toString(findTopThreeScores(scores3)));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of scores (>= 3): ");
            int n = scanner.nextInt();
            int[] scores = new int[n];
            System.out.println("Enter " + n + " scores:");
            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextInt();
            }
            int[] res = findTopThreeScores(scores);
            System.out.println("Top 3 Podium: " + Arrays.toString(res));
            scanner.close();
        }
    }
}
