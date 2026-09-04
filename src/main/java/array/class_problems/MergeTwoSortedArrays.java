package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Category C Practice Problem — L4: Merge Two Sorted Arrays
 *
 * Scenario:
 * Two class sections each submit their exam scores already sorted from lowest to highest.
 * The examination office needs one single combined sorted list — without throwing both
 * lists together and re-sorting everything from scratch.
 *
 * Concepts covered: Two-index (two-pointer) array traversal, while loops,
 * comparing and copying elements between arrays, handling a fully-consumed array.
 */
public class MergeTwoSortedArrays {

    /**
     * Merges two sorted integer arrays into a single sorted array.
     *
     * @param arr1 first sorted array
     * @param arr2 second sorted array
     * @return merged sorted array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return new int[]{};
        if (arr1 == null || arr1.length == 0) return arr2 != null ? arr2.clone() : new int[]{};
        if (arr2 == null || arr2.length == 0) return arr1.clone();

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare elements and copy smaller
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== L4: Merge Two Sorted Arrays ===");

        // Sample Test Case 1 from PDF
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println("Sample 1: arr1 = " + Arrays.toString(arr1) + ", arr2 = " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(mergeSortedArrays(arr1, arr2)));

        // Sample Test Case 2 from PDF
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        System.out.println("\nSample 2: arr1 = " + Arrays.toString(arr3) + ", arr2 = " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(mergeSortedArrays(arr3, arr4)));

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter size of array 1: ");
            int n1 = scanner.nextInt();
            int[] custom1 = new int[n1];
            System.out.println("Enter " + n1 + " sorted elements for array 1:");
            for (int idx = 0; idx < n1; idx++) custom1[idx] = scanner.nextInt();

            System.out.print("Enter size of array 2: ");
            int n2 = scanner.nextInt();
            int[] custom2 = new int[n2];
            System.out.println("Enter " + n2 + " sorted elements for array 2:");
            for (int idx = 0; idx < n2; idx++) custom2[idx] = scanner.nextInt();

            System.out.println("Merged: " + Arrays.toString(mergeSortedArrays(custom1, custom2)));
            scanner.close();
        }
    }
}
