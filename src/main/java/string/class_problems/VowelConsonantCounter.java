package string.class_problems;

import java.util.Scanner;

/**
 * Day 2 Live-Coding Session — Problem 1: Vowel & Consonant Counter
 *
 * Scenario:
 * A library orientation kiosk counts vowels and consonants in a submitted book title
 * for a simple text-stats display.
 *
 * Concepts covered: charAt(), length(), loops, case-insensitive character comparison.
 */
public class VowelConsonantCounter {

    /**
     * Counts vowels and consonants separately, ignoring spaces.
     *
     * @param text input string containing letters and spaces
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Invalid input: Text cannot be null.");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Ignore spaces or non-letter characters
            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Vowel & Consonant Counter ===");

        // Sample Test Case from PDF
        System.out.println("\nSample Test Case:");
        String sample1 = "Java Programming";
        System.out.println("Input: \"" + sample1 + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(sample1);

        // Additional Test Case
        System.out.println("\nAdditional Test Case:");
        String sample2 = "Data Structures and Algorithms";
        System.out.println("Input: \"" + sample2 + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(sample2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter text: ");
            String input = scanner.nextLine();
            System.out.print("Output: ");
            countVowelsAndConsonants(input);
            scanner.close();
        }
    }
}
