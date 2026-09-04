package string.assigment_problems;

import java.util.Scanner;

/**
 * Week 2 Assignment — Problem 1: ATM PIN Length Validator
 *
 * Scenario:
 * An ATM app must check that a PIN a customer enters is exactly 4 digits long
 * before allowing them to continue, using only the most basic checks.
 *
 * Concepts covered: length(), if / else, comparison operators — the smallest possible building blocks.
 */
public class AtmPinLengthValidator {

    /**
     * Checks if the PIN length is exactly 4 digits.
     *
     * @param pin the PIN string to validate
     */
    public static void checkPinLength(String pin) {
        if (pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: ATM PIN Length Validator ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String pin1 = "482";
        System.out.println("Input: \"" + pin1 + "\"");
        System.out.print("Output: ");
        checkPinLength(pin1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String pin2 = "4820";
        System.out.println("Input: \"" + pin2 + "\"");
        System.out.print("Output: ");
        checkPinLength(pin2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter ATM PIN: ");
            String input = scanner.nextLine();
            System.out.print("Output: ");
            checkPinLength(input);
            scanner.close();
        }
    }
}
