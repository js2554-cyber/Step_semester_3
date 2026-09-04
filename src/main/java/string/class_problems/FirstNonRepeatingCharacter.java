package string.class_problems;

import java.util.Scanner;

/**
 * Day 1 Live-Coding Session — Problem 4: First Non-Repeating Character
 *
 * Scenario:
 * The Unique Letter Hunt Mini-Game
 * A code-learning platform runs a light-hearted "Unique Letter Hunt" mini-game between exercises:
 * a player types any word or sentence, and the app must instantly find and highlight the first
 * character that appears only once in the entire input — a fun, quick way to reinforce
 * character-frequency thinking between coding drills.
 *
 * Concepts covered: Character frequency counting, loops, HashMap/array-based counting,
 * early-exit scanning.
 */
public class FirstNonRepeatingCharacter {

    /**
     * Finds the first non-repeating character in the given string.
     * Uses frequency counting and early-exit left-to-right scanning.
     *
     * @param text input string
     * @return the first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Count frequencies of each character (supports standard ASCII)
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                freq[ch]++;
            }
        }

        // Scan string left-to-right and find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && freq[ch] == 1) {
                return ch; // early exit
            }
        }

        return '\0';
    }

    /**
     * Helper method to display output matching PDF format.
     */
    public static void displayFirstNonRepeatingChar(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: First Non-Repeating Character ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String test1 = "swiss";
        System.out.println("Input: \"" + test1 + "\"");
        System.out.print("Output: ");
        displayFirstNonRepeatingChar(test1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String test2 = "aabbcc";
        System.out.println("Input: \"" + test2 + "\"");
        System.out.print("Output: ");
        displayFirstNonRepeatingChar(test2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter a word or sentence: ");
            String input = scanner.nextLine();
            System.out.print("Output: ");
            displayFirstNonRepeatingChar(input);
            scanner.close();
        }
    }
}
