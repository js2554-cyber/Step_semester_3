package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Category C Practice Problem — L3: Contains Duplicate
 *
 * Scenario:
 * Before finalizing an exam seating chart, the office must double-check that no roll number
 * was accidentally entered twice in the list — by comparing every entry against every other entry.
 *
 * Concepts covered: Nested loops, pairwise comparison, boolean return logic,
 * early exit from a loop once an answer is found.
 */
public class ContainsDuplicate {

    /**
     * Checks whether any value appears at least twice in the array using nested loops.
     *
     * @param nums array of integers
     * @return true if any duplicate exists, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== L3: Contains Duplicate ===");

        // Sample Test Case 1 from PDF
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Sample 1: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + containsDuplicate(nums1) + " (the value 1 appears at two different positions)");

        // Sample Test Case 2 from PDF
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("\nSample 2: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + containsDuplicate(nums2) + " (every value is distinct)");

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of elements: ");
            int n = scanner.nextInt();
            int[] customNums = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                customNums[i] = scanner.nextInt();
            }
            System.out.println("Contains Duplicate: " + containsDuplicate(customNums));
            scanner.close();
        }
    }
}
