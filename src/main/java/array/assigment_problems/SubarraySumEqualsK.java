package array.assigment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Week 4 Category C Assignment Problem — A4: Subarray Sum Equals K
 *
 * Scenario:
 * A hostel warden reviewing a semester's daily attendance-change log (some days net positive,
 * some negative, as students check in and out) wants to know how many different contiguous
 * stretches of days had a net change of exactly k — across the whole log.
 *
 * Concepts covered: Prefix sums, hash map frequency counting, why sliding-window techniques
 * require non-negative values to work correctly, careful initialization of the "empty prefix" base case.
 */
public class SubarraySumEqualsK {

    /**
     * Returns the total number of contiguous subarrays whose sum equals k.
     *
     * @param nums array of integers (may contain negative numbers)
     * @param k target sum
     * @return count of subarrays summing to k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int currentSum = 0;

        // Map from prefix sum to its frequency
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        // Base case: prefix sum of 0 has occurred once (empty prefix)
        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in map, add its frequency
            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }

            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== A4: Subarray Sum Equals K ===");

        // Sample Test Case 1 from PDF
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Sample 1: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + subarraySum(nums1, k1) + " (subarrays [1, 1] at 0-1 and 1-2 both sum to 2)");

        // Sample Test Case 2 from PDF
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("\nSample 2: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + subarraySum(nums2, k2));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of elements: ");
            int n = scanner.nextInt();
            int[] customNums = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) customNums[i] = scanner.nextInt();

            System.out.print("Enter k: ");
            int k = scanner.nextInt();
            System.out.println("Total Subarrays: " + subarraySum(customNums, k));
            scanner.close();
        }
    }
}
