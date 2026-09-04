package array.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Category C Assignment Problem — A2: Maximum Subarray
 *
 * Scenario:
 * A trader has a full year of daily profit-or-loss figures, some positive, some negative,
 * and wants to know the single best contiguous stretch of days to have been actively
 * trading — the run of consecutive days whose combined total is the highest possible.
 *
 * Concepts covered: Kadane's algorithm, the "extend vs. restart" decision at each step,
 * running-sum reset logic, handling an all-negative array correctly.
 */
public class MaximumSubarray {

    /**
     * Finds the contiguous subarray with the largest sum using Kadane's algorithm.
     *
     * @param nums array of integers (may contain negative numbers)
     * @return maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Extend running subarray or start fresh from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("=== A2: Maximum Subarray ===");

        // Sample Test Case 1 from PDF
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Sample 1: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + maxSubArray(nums1) + " (the subarray [4, -1, 2, 1] sums to 6)");

        // Sample Test Case 2 from PDF
        int[] nums2 = {-3, -1, -2};
        System.out.println("\nSample 2: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + maxSubArray(nums2) + " (all negative -- best is the single largest value)");

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of elements: ");
            int n = scanner.nextInt();
            int[] customNums = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) customNums[i] = scanner.nextInt();

            System.out.println("Max Subarray Sum: " + maxSubArray(customNums));
            scanner.close();
        }
    }
}
