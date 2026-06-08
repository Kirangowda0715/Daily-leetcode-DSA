/*
 * LeetCode 152 - Maximum Product Subarray
 *
 * Pattern:
 * Array Traversal / Prefix Product / Suffix Product
 *
 * Approach:
 * Maintain prefix and suffix products.
 * Reset product to 1 whenever it becomes 0.
 * The answer can be obtained by scanning from both directions
 * because the maximum product may require excluding either the
 * first negative or the last negative element.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxProduct(int[] nums) {

        int maxPro = Integer.MIN_VALUE;
        int n = nums.length;

        int pre = 1;
        int suff = 1;

        for (int i = 0; i < n; i++) {

            if (pre == 0)
                pre = 1;

            if (suff == 0)
                suff = 1;

            pre *= nums[i];
            suff *= nums[n - i - 1];

            maxPro = Math.max(maxPro, pre);
            maxPro = Math.max(maxPro, suff);
        }

        return maxPro;
    }
}