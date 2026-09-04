import java.util.Locale;
import java.util.Scanner;

/**
 * Week 1 - Problem 2: The Typing Speed Test Accuracy Checker
 *
 * Scenario:
 * An online typing-practice website shows users a fixed passage and asks them to retype it
 * as quickly and accurately as they can. Once the user submits their attempt, the system must
 * compare it character by character against the original passage and report exactly how accurate
 * the attempt was — along with the position of the very first mistake — so the user can see
 * precisely where their typing went wrong.
 *
 * Concepts covered: String traversal, charAt(), loops, conditional logic, percentage calculation.
 */
public class TypingSpeedTestAccuracyChecker {

    /**
     * Compares original and typed strings character-by-character,
     * calculates accuracy percentage, and reports the first mismatch if any.
     *
     * @param original the original passage
     * @param typed the text typed by the user
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: Strings cannot be null.");
            return;
        }

        int total = original.length();
        int compareLen = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < compareLen; i++) {
            char orig = original.charAt(i);
            char typ = typed.charAt(i);

            if (orig == typ) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-indexed position
                origChar = orig;
                typedChar = typ;
            }
        }

        // Check if lengths differ and no mismatch found yet
        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = compareLen + 1;
            origChar = original.length() > compareLen ? original.charAt(compareLen) : ' ';
            typedChar = typed.length() > compareLen ? typed.charAt(compareLen) : ' ';
        }

        int baseLen = Math.max(original.length(), typed.length());
        double accuracy = (baseLen == 0) ? 100.00 : ((double) matched / baseLen) * 100.0;

        if (firstMismatchPos != -1) {
            System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, baseLen, accuracy, firstMismatchPos, origChar, typedChar);
        } else {
            System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, baseLen, accuracy);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Typing Speed Test Accuracy Checker ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String orig1 = "hello world";
        String typed1 = "hello worlt";
        System.out.println("original=\"" + orig1 + "\", typed=\"" + typed1 + "\"");
        System.out.print("Output: ");
        checkTypingAccuracy(orig1, typed1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String orig2 = "coding";
        String typed2 = "coding";
        System.out.println("original=\"" + orig2 + "\", typed=\"" + typed2 + "\"");
        System.out.print("Output: ");
        checkTypingAccuracy(orig2, typed2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter original text: ");
            String customOrig = scanner.nextLine();
            System.out.print("Enter typed text:    ");
            String customTyped = scanner.nextLine();
            System.out.print("\nOutput: ");
            checkTypingAccuracy(customOrig, customTyped);
            scanner.close();
        }
    }
}
