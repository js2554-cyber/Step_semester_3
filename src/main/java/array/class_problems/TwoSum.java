package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Category C Practice Problem — L1: Two Sum
 *
 * Scenario:
 * A shopkeeper wants to find two items from a list of prices that together add up
 * to exactly a customer's budget. With only a handful of items on the shelf, the
 * simplest approach — checking every possible pair — is more than fast enough.
 *
 * Concepts covered: Nested for loops, array indexing, basic pairwise search logic.
 */
public class TwoSum {

    /**
     * Finds indices of the two numbers such that they add up to target.
     *
     * @param nums array of integers
     * @param target target sum
     * @return array containing the two indices [i, j]
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("=== L1: Two Sum ===");

        // Sample Test Case 1 from PDF
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] res1 = twoSum(nums1, target1);
        System.out.println("Sample 1: nums = [2, 7, 11, 15], target = 9");
        System.out.println("Output: " + Arrays.toString(res1));

        // Sample Test Case 2 from PDF
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] res2 = twoSum(nums2, target2);
        System.out.println("\nSample 2: nums = [3, 2, 4], target = 6");
        System.out.println("Output: " + Arrays.toString(res2));

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
            System.out.print("Enter target: ");
            int t = scanner.nextInt();
            int[] ans = twoSum(customNums, t);
            System.out.println("Result: " + Arrays.toString(ans));
            scanner.close();
        }
    }
}
