/*
 * LeetCode 918. Maximum Sum Circular Subarray
 *
 * Pattern:
 * Dynamic Programming (Kadane's Algorithm)
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Kadane's Algorithm
 * - Maximum Subarray Sum
 * - Minimum Subarray Sum
 * - Circular Array
 * - Prefix Intuition
 *
 * Approach:
 * 1. Compute the maximum subarray sum using Kadane's Algorithm.
 * 2. Compute the minimum subarray sum using Kadane's Algorithm.
 * 3. Calculate the total array sum.
 * 4. Circular maximum = Total Sum - Minimum Subarray Sum.
 * 5. Answer = max(Normal Kadane, Circular Kadane).
 * 6. Handle the all-negative case separately because
 *    Total - Minimum becomes 0 (empty subarray), which is invalid.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int curMinSum = nums[0];
        int minSum = nums[0];

        int curMaxSum = nums[0];
        int maxSum = nums[0];

        int total = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            total += num;

            // Minimum Kadane
            curMinSum = Math.min(curMinSum + num, num);
            minSum = Math.min(minSum, curMinSum);

            // Maximum Kadane
            curMaxSum = Math.max(curMaxSum + num, num);
            maxSum = Math.max(maxSum, curMaxSum);
        }

        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of normal and circular subarray
        return Math.max(maxSum, total - minSum);
    }
}