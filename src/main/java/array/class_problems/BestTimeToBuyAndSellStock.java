package array.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Week 4 Category C Practice Problem — L2: Best Time to Buy and Sell Stock
 *
 * Scenario:
 * A trainee investor has one week of daily stock prices and wants to know the single best
 * day to buy and the single best later day to sell, to make the largest possible profit —
 * found in one simple pass through the prices, left to right.
 *
 * Concepts covered: Single-pass array traversal, tracking a running minimum and a running
 * maximum together, basic comparison logic.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Calculates the maximum profit that can be achieved from a single buy and sell transaction.
     *
     * @param prices array of daily stock prices
     * @return maximum profit, or 0 if no profit can be made
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("=== L2: Best Time to Buy and Sell Stock ===");

        // Sample Test Case 1 from PDF
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Sample 1: prices = " + Arrays.toString(prices1));
        System.out.println("Output: " + maxProfit(prices1) + " (buy on day 2 at price 1, sell on day 5 at price 6)");

        // Sample Test Case 2 from PDF
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("\nSample 2: prices = " + Arrays.toString(prices2));
        System.out.println("Output: " + maxProfit(prices2) + " (prices only fall, so no trade is profitable)");

        // Interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of days: ");
            int n = scanner.nextInt();
            int[] customPrices = new int[n];
            System.out.println("Enter " + n + " prices:");
            for (int i = 0; i < n; i++) {
                customPrices[i] = scanner.nextInt();
            }
            System.out.println("Max Profit: " + maxProfit(customPrices));
            scanner.close();
        }
    }
}
