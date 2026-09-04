package string.assigment_problems;

import java.util.Scanner;

/**
 * Week 2 Assignment — Problem 2: Word Reversal Encoder
 *
 * Scenario:
 * The coding club's "mirror text" mini-game reverses every word in a sentence
 * individually while keeping the word order the same, so "hello club" becomes "olleh bulc".
 *
 * Concepts covered: split(), StringBuilder / reverse(), loops, string joining.
 */
public class WordReversalEncoder {

    /**
     * Reverses each word in the sentence individually while preserving word order.
     *
     * @param sentence input sentence with words separated by spaces
     * @return encoded sentence with reversed words
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            System.out.println("");
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Build reverse of the word using a loop and StringBuilder
            StringBuilder reversedWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            resultBuilder.append(reversedWord);

            // Join words with single space
            if (i < words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        String result = resultBuilder.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Word Reversal Encoder ===");

        // Sample Test Case from PDF
        System.out.println("\nSample Test Case:");
        String sentence1 = "hello club";
        System.out.println("Input: \"" + sentence1 + "\"");
        System.out.print("Output: ");
        reverseEachWord(sentence1);

        // Additional Test Case
        System.out.println("\nAdditional Test Case:");
        String sentence2 = "Step Semester 3 Java Programming";
        System.out.println("Input: \"" + sentence2 + "\"");
        System.out.print("Output: ");
        reverseEachWord(sentence2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter sentence: ");
            String input = scanner.nextLine();
            System.out.print("Output: ");
            reverseEachWord(input);
            scanner.close();
        }
    }
}
