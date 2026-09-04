package string.assigment_problems;

import java.util.Scanner;

/**
 * Week 1 Assignment — Problem 4: The Warehouse Inventory Balancer
 *
 * Scenario:
 * A retail warehouse stores the same product categories across two storage sections,
 * Section A and Section B. Before the monthly stock report is generated, the inventory
 * team wants to confirm both sections hold matching total quantities (to catch data-entry
 * mismatches) and also identify the single highest-quantity item across the whole warehouse.
 *
 * Concepts covered: Arrays, loops, sum accumulation, conditional comparison, tracking maximum with its index.
 */
public class WarehouseInventoryBalancer {

    /**
     * Analyzes inventory between Section A and Section B.
     * Computes section totals, checks balance status, and finds single highest quantity item.
     *
     * @param sectionA array of item quantities in Section A
     * @param sectionB array of item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length == 0 || sectionB.length == 0) {
            System.out.println("Invalid inventory data.");
            return;
        }

        int totalA = 0;
        int highestQty = sectionA[0];
        String highestSection = "Section A";
        int highestItem = 1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestItem = i + 1; // 1-indexed Item number
            }
        }

        int totalB = 0;
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestItem = i + 1; // 1-indexed Item number
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQty, highestSection, highestItem);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Warehouse Inventory Balancer ===");

        // Sample Test Case from PDF
        System.out.println("\nSample Test Case:");
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        System.out.println("sectionA={20,15,30}, sectionB={25,10,30}");
        System.out.print("Output: ");
        analyzeInventory(sectionA, sectionB);

        // Additional Test Case
        System.out.println("\nAdditional Test Case (Not Balanced, Section B Highest):");
        int[] secA2 = {10, 20, 15};
        int[] secB2 = {15, 45, 10};
        System.out.println("sectionA={10,20,15}, sectionB={15,45,10}");
        System.out.print("Output: ");
        analyzeInventory(secA2, secB2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of items in each section: ");
            int n = scanner.nextInt();
            int[] customA = new int[n];
            int[] customB = new int[n];
            System.out.println("Enter " + n + " quantities for Section A:");
            for (int i = 0; i < n; i++) {
                customA[i] = scanner.nextInt();
            }
            System.out.println("Enter " + n + " quantities for Section B:");
            for (int i = 0; i < n; i++) {
                customB[i] = scanner.nextInt();
            }
            System.out.print("\nOutput: ");
            analyzeInventory(customA, customB);
            scanner.close();
        }
    }
}
