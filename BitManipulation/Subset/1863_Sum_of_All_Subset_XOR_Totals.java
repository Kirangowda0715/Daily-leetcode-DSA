import java.util.*;

/*
 * LeetCode 1863 - Sum of All Subset XOR Totals
 *
 * Pattern   : Bit Manipulation / Power Set
 * Difficulty: Easy
 * Concepts  : Bitmasking, Subsets, XOR
 *
 * Approach:
 * Generate all 2^n subsets using bitmasks.
 *
 * For each mask:
 * - Bit = 1 -> include nums[i]
 * - Bit = 0 -> exclude nums[i]
 *
 * Calculate the XOR of every subset and add it to xorSum.
 *
 * Time Complexity : O(n * 2^n)
 * Space Complexity: O(1) excluding output/loop variables
 */

class Solution {

    // Optimal for this approach: Bitmask / Power Set
    public int subsetXORSum(int[] nums) {

        int n = nums.length;
        int xorSum = 0;

        // Total number of subsets = 2^n
        int subsets = 1 << n;

        // Generate every possible subset
        for (int mask = 0; mask < subsets; mask++) {

            int xor = 0;

            // Check every element
            for (int i = 0; i < n; i++) {

                // If i-th bit is set, include nums[i]
                if ((mask & (1 << i)) != 0) {
                    xor ^= nums[i];
                }
            }

            // Add current subset's XOR
            xorSum += xor;
        }

        return xorSum;
    }
}