package string.class_problems;

import java.util.Scanner;

/**
 * Day 2 Live-Coding Session — Problem 5: Bank Transaction Reference Generator & Validator
 *
 * Scenario:
 * A fintech onboarding module for a placement-prep hackathon needs to both normalize
 * and validate transaction reference codes. A valid reference is exactly 14 characters:
 * 3 letters (bank code) + 6 digits (date, ddMMyy) + 5 digits (sequence number).
 *
 * Concepts covered: trim(), substring(), string concatenation, Character.isLetter()/isDigit(),
 * StringBuilder, multi-stage validation.
 */
public class BankTransactionReferenceValidator {

    /**
     * Normalizes raw reference by trimming spaces and capitalizing first 3 characters.
     *
     * @param raw raw reference string with possible stray spaces and mixed case
     * @return normalized string
     */
    public static String normalizeReference(String raw) {
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
     * Validates normalized reference and formats it into display string using StringBuilder.
     *
     * @param reference normalized reference string
     * @return formatted display string, or error reason
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            String err = "Invalid: wrong length (must be 14 characters)";
            System.out.println(err);
            return err;
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                String err = "Invalid: bank code must be 3 letters";
                System.out.println(err);
                return err;
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                String err = "Invalid: body must be 11 digits (date and sequence)";
                System.out.println(err);
                return err;
            }
        }

        // Extract components: 3 bank code, 6 date (ddMMyy), 5 sequence
        String bankCode = reference.substring(0, 3);
        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(dd).append("/").append(mm).append("/").append(yy)
          .append(" | SEQ: ").append(seq);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Bank Transaction Reference Generator & Validator ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String raw1 = " hdf03022600042 ";
        System.out.println("Input: \"" + raw1 + "\"");
        String norm1 = normalizeReference(raw1);
        System.out.print("Output: ");
        validateAndFormat(norm1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String raw2 = "12F03022600042";
        System.out.println("Input: \"" + raw2 + "\"");
        String norm2 = normalizeReference(raw2);
        System.out.print("Output: ");
        validateAndFormat(norm2);

        // Additional Test Case
        System.out.println("\nAdditional Test Case (SBI):");
        String raw3 = " sbi15082600109 ";
        System.out.println("Input: \"" + raw3 + "\"");
        String norm3 = normalizeReference(raw3);
        System.out.print("Output: ");
        validateAndFormat(norm3);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter raw transaction reference: ");
            String input = scanner.nextLine();
            String norm = normalizeReference(input);
            System.out.print("Output: ");
            validateAndFormat(norm);
            scanner.close();
        }
    }
}
