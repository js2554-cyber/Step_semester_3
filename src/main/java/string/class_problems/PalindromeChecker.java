package string.class_problems;

import java.util.Scanner;

/**
 * Day 1 Live-Coding Session — Problem 2: Palindrome Checker (3 Approaches)
 *
 * Scenario:
 * The QA Text Verification Toolkit
 * The QA team on a coding-assessment platform is building a small internal toolkit
 * to sanity-check palindrome-detection logic before it ships to students as a graded exercise.
 * To make sure the logic is solid regardless of implementation style, the toolkit must verify
 * a given text using three independent approaches — iterative comparison, recursion, and
 * array reversal — and confirm all three agree on the result.
 *
 * Concepts covered: Loops, recursion, array manipulation, string comparison,
 * comparing implementation trade-offs.
 */
public class PalindromeChecker {

    /**
     * Approach 1: Iterative check
     * Compares characters from both ends moving inward toward the middle.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check
     * Recursively compares the first and last characters, shrinking the substring each call.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Array-reversal check
     * Converts the string to a character array, reverses it, and compares it to the original.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            return false;
        }

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to format the output string across all three approaches.
     */
    public static String formatResult(String text) {
        String iter = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String rec = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String rev = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        return String.format("Iterative: %s | Recursive: %s | Array Reversal: %s", iter, rec, rev);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Palindrome Checker (3 Approaches) ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String test1 = "madam";
        System.out.println("Input: \"" + test1 + "\"");
        System.out.println("Output:\n" + formatResult(test1));

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String test2 = "hello";
        System.out.println("Input: \"" + test2 + "\"");
        System.out.println("Output:\n" + formatResult(test2));

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter a word or phrase to test: ");
            String input = scanner.nextLine();
            System.out.println("Output:\n" + formatResult(input));
            scanner.close();
        }
    }
}
