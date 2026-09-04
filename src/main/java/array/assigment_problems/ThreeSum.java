package array.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Week 4 Category C Assignment Problem — A3: 3Sum
 *
 * Scenario:
 * A budgeting tool needs to find every distinct combination of exactly three transactions
 * in a student's account history that cancel each other out exactly — summing to zero —
 * without ever reporting the same combination of amounts twice.
 *
 * Concepts covered: Sorting as a setup step, two-pointer technique on a sorted array,
 * systematic duplicate avoidance, converting a 2-sum idea into a 3-sum solution.
 */
public class ThreeSum {

    /**
     * Finds all unique triplets in the array that sum to zero.
     *
     * @param nums array of integers
     * @return 2D array of unique triplets [[a, b, c], ...]
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        // Sort array first
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("=== A3: 3Sum ===");

        // Sample Test Case 1 from PDF
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Sample 1: nums = " + Arrays.toString(nums1));
        int[][] res1 = threeSum(nums1);
        System.out.println("Output: " + Arrays.deepToString(res1));

        // Sample Test Case 2 from PDF
        int[] nums2 = {0, 0, 0};
        System.out.println("\nSample 2: nums = " + Arrays.toString(nums2));
        int[][] res2 = threeSum(nums2);
        System.out.println("Output: " + Arrays.deepToString(res2) + " (only reported once, despite three identical values)");

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of elements: ");
            int n = scanner.nextInt();
            int[] customNums = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) customNums[i] = scanner.nextInt();

            int[][] ans = threeSum(customNums);
            System.out.println("Triplets: " + Arrays.deepToString(ans));
            scanner.close();
        }
    }
}
