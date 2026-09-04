package array.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Category C Assignment Problem — A5: Find Minimum in Rotated Sorted Array
 *
 * Scenario:
 * A circular duty roster was originally sorted by join date, then "rotated" at some
 * unknown point when the office started the printed list from a different staff member
 * instead of the very first one. Given only the resulting list, find the original
 * earliest join date — without scanning every entry one by one.
 *
 * Concepts covered: Binary search adapted to a rotated (not fully sorted) array,
 * deciding which half genuinely contains the answer, correctly handling already-sorted case.
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Finds the minimum element in an ascending sorted array that has been rotated.
     * Operates in O(log n) time using binary search.
     *
     * @param nums rotated sorted array of unique integers
     * @return minimum integer in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be strictly in the right half
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("=== A5: Find Minimum in Rotated Sorted Array ===");

        // Sample Test Case 1 from PDF
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Sample 1: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + findMin(nums1));

        // Sample Test Case 2 from PDF
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("\nSample 2: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + findMin(nums2));

        // Sample Test Case 3 from PDF (already sorted)
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("\nSample 3: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + findMin(nums3) + " (no rotation actually occurred)");

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of elements: ");
            int n = scanner.nextInt();
            int[] customNums = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) customNums[i] = scanner.nextInt();

            System.out.println("Minimum Element: " + findMin(customNums));
            scanner.close();
        }
    }
}
