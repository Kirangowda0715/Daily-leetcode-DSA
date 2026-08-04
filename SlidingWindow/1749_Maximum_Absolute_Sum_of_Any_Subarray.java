/*
 * LeetCode 1749. Maximum Absolute Sum of Any Subarray
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
 * - Absolute Value
 *
 * Approach:
 * 1. Compute the maximum subarray sum using Kadane's Algorithm.
 * 2. Compute the minimum subarray sum using Reverse Kadane.
 * 3. The maximum absolute sum is the larger of:
 *      - Maximum Subarray Sum
 *      - Absolute Minimum Subarray Sum
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxAbsoluteSum(int[] nums) {

        int curMaxS = nums[0];
        int maxS = nums[0];

        int curMinS = nums[0];
        int minS = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Maximum Kadane
            curMaxS = Math.max(curMaxS + nums[i], nums[i]);
            maxS = Math.max(maxS, curMaxS);

            // Minimum Kadane
            curMinS = Math.min(curMinS + nums[i], nums[i]);
            minS = Math.min(minS, curMinS);
        }

        return Math.max(maxS, Math.abs(minS));
    }
}