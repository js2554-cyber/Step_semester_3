package string.class_problems;

import java.util.Scanner;

/**
 * Day 2 Live-Coding Session — Problem 4: Masked Phone Number Formatter
 *
 * Scenario:
 * A student-support call center displays a partially masked version of a registered
 * phone number on-screen for privacy, while agents confirm identity using the last 4 digits.
 *
 * Concepts covered: String length/digit validation, substring(), StringBuilder insert(), masking patterns.
 */
public class MaskedPhoneNumberFormatter {

    /**
     * Validates and masks a 10-digit phone number in the format XXXXXX-last4digits.
     *
     * @param phone 10-digit phone number as a string
     * @return masked phone number, or "Invalid phone number"
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            System.out.println("Invalid phone number");
            return "Invalid phone number";
        }

        // Validate all characters are numeric digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                System.out.println("Invalid phone number");
                return "Invalid phone number";
            }
        }

        // Build masked version using StringBuilder and insert()
        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append(phone.substring(6));
        sb.insert(6, "-");

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Masked Phone Number Formatter ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String phone1 = "9876543210";
        System.out.println("Input: \"" + phone1 + "\"");
        System.out.print("Output: ");
        maskPhoneNumber(phone1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String phone2 = "98765";
        System.out.println("Input: \"" + phone2 + "\"");
        System.out.print("Output: ");
        maskPhoneNumber(phone2);

        // Additional Test Case
        System.out.println("\nAdditional Test Case (non-digits):");
        String phone3 = "987654321a";
        System.out.println("Input: \"" + phone3 + "\"");
        System.out.print("Output: ");
        maskPhoneNumber(phone3);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter phone number: ");
            String input = scanner.nextLine();
            System.out.print("Output: ");
            maskPhoneNumber(input);
            scanner.close();
        }
    }
}
