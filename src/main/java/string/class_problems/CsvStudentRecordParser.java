package string.class_problems;

import java.util.Scanner;

/**
 * Day 2 Live-Coding Session — Problem 2: CSV Student Record Parser
 *
 * Scenario:
 * The T&P team receives student registration data as CSV lines and needs a quick parser
 * to split each line into fields and print a formatted record.
 *
 * Concepts covered: split(), array length validation, string concatenation, formatted output.
 */
public class CsvStudentRecordParser {

    /**
     * Parses a student CSV line and prints formatted record or invalid message.
     *
     * @param csvLine CSV string in the form "Name,RollNumber,Department"
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: CSV Student Record Parser ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String line1 = "Ananya Verma,RA2211003010123,CSE";
        System.out.println("Input: \"" + line1 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(line1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String line2 = "Ananya Verma,CSE";
        System.out.println("Input: \"" + line2 + "\"");
        System.out.print("Output: ");
        parseStudentRecord(line2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter CSV record (Name,RollNumber,Department): ");
            String input = scanner.nextLine();
            System.out.print("Output: ");
            parseStudentRecord(input);
            scanner.close();
        }
    }
}
