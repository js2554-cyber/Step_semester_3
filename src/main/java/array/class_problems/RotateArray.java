package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Category C Practice Problem — L5: Rotate Array
 *
 * Scenario:
 * A playlist needs to be shifted so the last few songs move to the front of the queue,
 * rotating the whole list to the right by a given number of positions — solved the
 * most direct way: work out exactly where every song lands, and build the new order from scratch.
 *
 * Concepts covered: Modulo arithmetic for wraparound indexing, building a new array
 * from calculated positions, basic array copying.
 */
public class RotateArray {

    /**
     * Rotates an array to the right by k steps.
     *
     * @param nums array of integers
     * @param k number of positions to rotate to the right
     * @return rotated array
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k += n;
        }
        if (k == 0) {
            return nums;
        }

        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        // Copy back into original array
        System.arraycopy(newArray, 0, nums, 0, n);

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("=== L5: Rotate Array ===");

        // Sample Test Case 1 from PDF
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Sample 1: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        rotateArray(nums1, k1);
        System.out.println("Output: " + Arrays.toString(nums1));

        // Sample Test Case 2 from PDF
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("\nSample 2: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        rotateArray(nums2, k2);
        System.out.println("Output: " + Arrays.toString(nums2) + " (k % length = 3 % 2 = 1, a single rotation)");

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
            rotateArray(customNums, k);
            System.out.println("Rotated: " + Arrays.toString(customNums));
            scanner.close();
        }
    }
}
