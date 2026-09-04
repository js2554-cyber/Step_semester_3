package string.assigment_problems;

import java.util.Scanner;

/**
 * Week 1 Assignment — Problem 5: The Movie Review Word Length Profiler
 *
 * Scenario:
 * A movie-review platform's moderation tool scans newly submitted reviews and profiles
 * the length of the words used in them — reviews stuffed with unusually many very short
 * or very long words are more likely to be spam or bot-generated, so moderators want a
 * quick word-length breakdown before a review is allowed to go live.
 *
 * Concepts covered: String splitting (split()), loops, conditional logic, counting/categorization.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Splits review into individual words and classifies each as:
     * - Short (1-4 letters)
     * - Medium (5-8 letters)
     * - Long (9+ letters)
     *
     * @param review single string input of the movie review
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int letterCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) {
                    letterCount++;
                }
            }

            int length = (letterCount > 0) ? letterCount : word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Movie Review Word Length Profiler ===");

        // Sample Test Case from PDF
        System.out.println("\nSample Test Case:");
        String review1 = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + review1 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review1);

        // Additional Test Case
        System.out.println("\nAdditional Test Case:");
        String review2 = "The cinematography and spectacular visual effects made it an extraordinary masterpiece";
        System.out.println("Input: \"" + review2 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter movie review text: ");
            String customReview = scanner.nextLine();
            System.out.print("Output: ");
            classifyWordLengths(customReview);
            scanner.close();
        }
    }
}
