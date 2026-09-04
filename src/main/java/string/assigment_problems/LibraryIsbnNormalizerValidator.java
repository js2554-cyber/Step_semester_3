package string.assigment_problems;

import java.util.Scanner;

/**
 * Week 2 Assignment — Problem 4: Library ISBN Normalizer & Validator
 *
 * Scenario:
 * A library system's book-intake scanner needs to both normalize and validate ISBN-style codes.
 * A valid code is exactly 13 characters: 3 letters (publisher code) + 4 digits (year) + 6 digits (catalog number).
 *
 * Concepts covered: trim(), substring(), string concatenation, Character.isLetter()/isDigit(),
 * StringBuilder, multi-stage validation.
 */
public class LibraryIsbnNormalizerValidator {

    /**
     * Normalizes raw code by trimming spaces and converting the first 3 characters to uppercase.
     *
     * @param raw raw ISBN-style string
     * @return normalized string
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates normalized code and creates formatted display string using StringBuilder.
     *
     * @param code normalized 13-character code
     * @return formatted string or specific validation failure reason
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            String err = "Invalid: wrong length (must be 13 characters)";
            System.out.println(err);
            return err;
        }

        // Validate first 3 characters are letters (publisher code)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                String err = "Invalid: publisher code must be 3 letters";
                System.out.println(err);
                return err;
            }
        }

        // Validate remaining 10 characters are digits (4-digit year + 6-digit catalog number)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                String err = "Invalid: body must contain 10 digits (year and catalog number)";
                System.out.println(err);
                return err;
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ")
          .append(year).append(" | CATALOG: ").append(catalog);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Library ISBN Normalizer & Validator ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String raw1 = " pen2026004251 ";
        System.out.println("Input: \"" + raw1 + "\"");
        String norm1 = normalizeCode(raw1);
        System.out.print("Output: ");
        validateAndFormat(norm1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String raw2 = "12N2026004251";
        System.out.println("Input: \"" + raw2 + "\"");
        String norm2 = normalizeCode(raw2);
        System.out.print("Output: ");
        validateAndFormat(norm2);

        // Additional Test Case
        System.out.println("\nAdditional Test Case:");
        String raw3 = " ora2024019823 ";
        System.out.println("Input: \"" + raw3 + "\"");
        String norm3 = normalizeCode(raw3);
        System.out.print("Output: ");
        validateAndFormat(norm3);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter raw ISBN code: ");
            String input = scanner.nextLine();
            String norm = normalizeCode(input);
            System.out.print("Output: ");
            validateAndFormat(norm);
            scanner.close();
        }
    }
}
