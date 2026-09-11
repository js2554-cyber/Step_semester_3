package arrays_and_methods.class_problems;

import java.util.Scanner;

/**
 * Week 5 Category C Practice Problem — Problem 2: Duplicate Team Name Finder
 *
 * Problem Statement:
 * Hackathon registration is chaotic, and the organizers suspect the same team
 * accidentally submitted their name twice under two different form entries.
 * Write a method that scans the list of registered team names and reports the
 * first duplicate it finds.
 *
 * Requirements:
 * - Compare every name against every other name using plain nested loops — no Collections class of any kind.
 * - Report the first duplicate found, scanning in order; if none exist, say so clearly.
 *
 * Constraints:
 * - Up to 100 team names.
 * - Comparison is case-sensitive.
 */
public class DuplicateTeamNameFinder {

    /**
     * Scans registered team names using pairwise nested loops and reports the first duplicate found.
     *
     * @param teamNames array of registered team names
     * @return "Duplicate Found: <name>" if a duplicate is found, otherwise "No Duplicates Found"
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length == 0) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Duplicate Team Name Finder ===");

        // Sample Test Case 1 from PDF
        String[] sample1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println("Input:  [\"ByteForce\", \"CodeCrafters\", \"ByteForce\"]");
        System.out.println("Output: " + findDuplicateTeam(sample1));
        System.out.println("Expected: Duplicate Found: ByteForce");

        // Sample Test Case 2 from PDF
        String[] sample2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("\nInput:  [\"ByteForce\", \"CodeCrafters\", \"NullPointers\"]");
        System.out.println("Output: " + findDuplicateTeam(sample2));
        System.out.println("Expected: No Duplicates Found");

        // Case-sensitivity test
        String[] sample3 = {"byteforce", "ByteForce"};
        System.out.println("\nInput (case-sensitive check): [\"byteforce\", \"ByteForce\"]");
        System.out.println("Output: " + findDuplicateTeam(sample3));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of teams: ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            String[] teams = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Team " + (i + 1) + ": ");
                teams[i] = scanner.nextLine().trim();
            }
            System.out.println("Result: " + findDuplicateTeam(teams));
            scanner.close();
        }
    }
}
