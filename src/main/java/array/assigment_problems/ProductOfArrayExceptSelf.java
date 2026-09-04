package array.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Category C Assignment Problem — A1: Product of Array Except Self
 *
 * Scenario:
 * A pricing engine needs, for every product in a bundle, the combined price of every
 * OTHER product in that same bundle — computed for all products at once, without ever
 * dividing by the current product's own price (some prices could legitimately be zero,
 * e.g. a free promotional item, which would make division undefined).
 *
 * Concepts covered: Prefix and suffix products, two-pass array traversal,
 * handling zero values without dividing, O(n) time with O(1) extra space beyond output.
 */
public class ProductOfArrayExceptSelf {

    /**
     * Calculates the product of all elements except self without using division.
     *
     * @param nums input integer array
     * @return answer array where answer[i] is product of all elements except nums[i]
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: answer[i] contains product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: accumulate running product from the right and multiply into answer[i]
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== A1: Product of Array Except Self ===");

        // Sample Test Case 1 from PDF
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Sample 1: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));

        // Sample Test Case 2 from PDF
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("\nSample 2: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)) + " (a single zero forces every OTHER position to be 0)");

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of elements: ");
            int n = scanner.nextInt();
            int[] customNums = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) customNums[i] = scanner.nextInt();

            System.out.println("Result: " + Arrays.toString(productExceptSelf(customNums)));
            scanner.close();
        }
    }
}
