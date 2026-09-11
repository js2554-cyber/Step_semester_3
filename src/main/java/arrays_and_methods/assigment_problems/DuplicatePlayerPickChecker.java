package arrays_and_methods.assigment_problems;

import java.util.Scanner;

/**
 * Week 5 Category C Assignment Problem — Problem 2: Duplicate Player Pick Checker
 *
 * Problem Statement:
 * A glitch in the fantasy app's draft screen occasionally lets a user tap the same
 * player twice before the UI catches up, silently adding them to the lineup twice.
 * Write a method that checks a submitted lineup for a repeated player name before it's accepted.
 *
 * Requirements:
 * - Compare every name against every other name using plain nested loops — no Collections class of any kind.
 * - Report the first duplicate found, scanning in order; if none exist, say so clearly.
 *
 * Constraints:
 * - Lineup size up to 11 players.
 * - Comparison is case-sensitive.
 */
public class DuplicatePlayerPickChecker {

    /**
     * Checks a submitted lineup for repeated player names using nested loops.
     * Compares each name only against subsequent names to optimize comparisons.
     *
     * @param playerNames array of player names submitted in the draft lineup
     * @return "Duplicate Found: <name>" if duplicate exists, otherwise "No Duplicates Found"
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Duplicate Player Pick Checker ===");

        // Sample Test Case 1 from PDF
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Lineup 1: [\"Kohli\", \"Bumrah\", \"Kohli\", \"Rohit\"]");
        System.out.println("Output:   " + findDuplicatePick(lineup1));
        System.out.println("Expected: Duplicate Found: Kohli");

        // Sample Test Case 2 from PDF
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("\nLineup 2: [\"Kohli\", \"Bumrah\", \"Rohit\"]");
        System.out.println("Output:   " + findDuplicatePick(lineup2));
        System.out.println("Expected: No Duplicates Found");

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter lineup size: ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            String[] lineup = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Player " + (i + 1) + ": ");
                lineup[i] = scanner.nextLine().trim();
            }
            System.out.println("Result: " + findDuplicatePick(lineup));
            scanner.close();
        }
    }
}
