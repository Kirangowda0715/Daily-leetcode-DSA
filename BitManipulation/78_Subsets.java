import java.util.*;

/*
 * LeetCode 78 - Subsets
 *
 * Pattern   : Bit Manipulation / Power Set
 * Difficulty: Medium
 * Concepts  : Bitmasking, Power Set
 *
 * Approach:
 * Each element has 2 choices:
 * 1. Include it
 * 2. Exclude it
 *
 * Therefore, n elements produce 2^n subsets.
 *
 * We use every number from 0 to 2^n - 1 as a bitmask.
 * If the j-th bit is set, nums[j] is included in the subset.
 *
 * Time Complexity : O(n * 2^n)
 * Space Complexity: O(n * 2^n) - output space
 */

class Solution {

    // Optimal: Power Set using Bit Manipulation
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        int total = 1 << n; // 2^n

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                // Check whether j-th bit is set
                if ((mask & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }

            ans.add(subset);
        }

        return ans;
    }
}