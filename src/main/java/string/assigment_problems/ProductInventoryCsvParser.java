package string.assigment_problems;

import java.util.Scanner;

/**
 * Week 2 Assignment — Problem 3: Product Inventory CSV Parser
 *
 * Scenario:
 * The warehouse team receives inventory updates as CSV lines and needs a quick
 * parser to split each line into fields and print a formatted record.
 *
 * Concepts covered: split(), array length validation, string concatenation, formatted output.
 */
public class ProductInventoryCsvParser {

    /**
     * Parses an inventory CSV record and prints the formatted record.
     *
     * @param csvLine CSV line in format "ProductName,SKU,Quantity"
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String product = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        System.out.println("Product: " + product + " | SKU: " + sku + " | Qty: " + qty);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Product Inventory CSV Parser ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String line1 = "Wireless Mouse,WM-2201,150";
        System.out.println("Input: \"" + line1 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(line1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String line2 = "Wireless Mouse,150";
        System.out.println("Input: \"" + line2 + "\"");
        System.out.print("Output: ");
        parseInventoryRecord(line2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter inventory CSV record (ProductName,SKU,Quantity): ");
            String input = scanner.nextLine();
            System.out.print("Output: ");
            parseInventoryRecord(input);
            scanner.close();
        }
    }
}
