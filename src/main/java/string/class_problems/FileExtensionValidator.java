package string.class_problems;

import java.util.Scanner;

/**
 * Day 2 Live-Coding Session — Problem 3: File Extension Validator
 *
 * Scenario:
 * An assignment-upload portal must check whether an uploaded filename has an accepted
 * extension (pdf, docx, zip) regardless of case, before accepting the submission.
 *
 * Concepts covered: lastIndexOf(), substring(), equalsIgnoreCase(), conditional logic.
 */
public class FileExtensionValidator {

    /**
     * Validates whether a file extension matches accepted formats (pdf, docx, zip).
     *
     * @param filename the name of the file to validate
     * @return "Accepted" if valid, otherwise "Rejected — invalid file type"
     */
    public static String validateFileExtension(String filename) {
        String result;

        if (filename == null || !filename.contains(".")) {
            result = "Rejected — invalid file type";
        } else {
            int lastDotIndex = filename.lastIndexOf('.');
            if (lastDotIndex == filename.length() - 1) {
                result = "Rejected — invalid file type";
            } else {
                String extension = filename.substring(lastDotIndex + 1);

                if (extension.equalsIgnoreCase("pdf") ||
                    extension.equalsIgnoreCase("docx") ||
                    extension.equalsIgnoreCase("zip")) {
                    result = "Accepted";
                } else {
                    result = "Rejected — invalid file type";
                }
            }
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: File Extension Validator ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String file1 = "Assignment1.PDF";
        System.out.println("Input: \"" + file1 + "\"");
        System.out.print("Output: ");
        validateFileExtension(file1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String file2 = "notes.txt";
        System.out.println("Input: \"" + file2 + "\"");
        System.out.print("Output: ");
        validateFileExtension(file2);

        // Additional Test Cases
        System.out.println("\nAdditional Test Cases:");
        System.out.print("project.zip -> ");
        validateFileExtension("project.zip");
        System.out.print("report.DOCX -> ");
        validateFileExtension("report.DOCX");

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter filename: ");
            String input = scanner.nextLine();
            System.out.print("Output: ");
            validateFileExtension(input);
            scanner.close();
        }
    }
}
