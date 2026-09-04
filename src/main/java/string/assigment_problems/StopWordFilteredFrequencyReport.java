package string.assigment_problems;

import java.util.*;

/**
 * Week 2 Assignment — Problem 5: Stop-Word-Filtered Word Frequency Report
 *
 * Scenario:
 * The T&P team wants word-frequency analysis of feedback paragraphs, but common filler words
 * ("the", "was", "and", "a", "is") should be excluded so the report highlights meaningful
 * themes instead of function words.
 *
 * Concepts covered: replace(), split() with whitespace pattern, stop-word filtering,
 * frequency counting, sorting by a derived value.
 */
public class StopWordFilteredFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    /**
     * Filters stop words from feedback text and prints unique words sorted by frequency descending.
     *
     * @param feedback paragraph of feedback text
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No words found.");
            return;
        }

        // Normalize: convert to lowercase and strip punctuation using replace()
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "");

        String[] words = cleaned.trim().split("\\s+");

        // Count frequency of non-stop words
        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Stop-Word-Filtered Word Frequency Report ===");

        // Sample Test Case from PDF
        System.out.println("\nSample Test Case:");
        String feedback1 = "The mentor was great, the session was great and clear.";
        System.out.println("Input:\n\"" + feedback1 + "\"");
        System.out.println("Output:");
        printFilteredWordFrequency(feedback1);

        // Additional Test Case
        System.out.println("\nAdditional Test Case:");
        String feedback2 = "Java is powerful and Java is popular in software industry.";
        System.out.println("Input:\n\"" + feedback2 + "\"");
        System.out.println("Output:");
        printFilteredWordFrequency(feedback2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter feedback paragraph: ");
            String input = scanner.nextLine();
            System.out.println("\nOutput:");
            printFilteredWordFrequency(input);
            scanner.close();
        }
    }
}
