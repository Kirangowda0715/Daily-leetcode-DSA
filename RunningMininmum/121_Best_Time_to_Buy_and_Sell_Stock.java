/*
 * LeetCode 121. Best Time to Buy and Sell Stock
 *
 * Pattern:
 * Running Minimum (Prefix Minimum)
 *
 * Approach:
 * Traverse the array while maintaining the minimum stock price seen so far.
 * For every price, calculate the profit if we sell on that day.
 * Update the maximum profit whenever a larger profit is found.
 *
 * Example:
 * prices = [7,1,5,3,6,4]
 *
 * Day 1: min = 7, profit = 0
 * Day 2: min = 1, profit = 0
 * Day 3: profit = 5 - 1 = 4
 * Day 4: profit = 3 - 1 = 2
 * Day 5: profit = 6 - 1 = 5
 * Day 6: profit = 4 - 1 = 3
 *
 * Maximum Profit = 5
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxProfit(int[] prices) {

        // Minimum stock price encountered so far
        int minPrice = Integer.MAX_VALUE;

        // Maximum profit that can be achieved
        int maxProfit = 0;

        // Traverse each day's stock price
        for (int price : prices) {

            // Update the minimum buying price
            if (price < minPrice) {
                minPrice = price;
            }

            // Profit obtained if we sell today
            int currentProfit = price - minPrice;

            // Update the maximum profit
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}
