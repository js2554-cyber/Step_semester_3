import java.util.Scanner;

/**
 * Day 1 Live-Coding Session — Problem 5: Reverse Customer Name
 *
 * Scenario:
 * The Customer Identity Verification System
 * You are developing a customer identity verification module for a banking application.
 * As part of an internal security exercise, the system generates a reversed version of a
 * customer's name to verify whether the application correctly processes character sequences
 * without modifying the original data. This feature is used only for testing and training
 * purposes. The system should accept a customer's name and display its reverse while keeping
 * the original name unchanged.
 *
 * Concepts covered: String traversal, character array manipulation, string reconstruction.
 */
public class ReverseCustomerName {

    /**
     * Reverses the given customer name using character array manipulation and traversal.
     * Leaves the original string immutable and unchanged.
     *
     * @param customerName the customer's name
     * @return the reversed name string
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        char[] reversed = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }

        return new String(reversed);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Reverse Customer Name ===");

        // Sample Test Case from PDF
        System.out.println("\nSample Test Case:");
        String name = "Sunil";
        String reversed = reverseCustomerName(name);
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);

        // Additional Sample Case
        System.out.println("\nAdditional Test Case:");
        String name2 = "Jagrit Shaw";
        String reversed2 = reverseCustomerName(name2);
        System.out.println("Original Name: " + name2);
        System.out.println("Reversed Name: " + reversed2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter customer name: ");
            String customName = scanner.nextLine();
            String rev = reverseCustomerName(customName);
            System.out.println("Original Name: " + customName);
            System.out.println("Reversed Name: " + rev);
            scanner.close();
        }
    }
}
