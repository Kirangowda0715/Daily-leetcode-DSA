/*
 * LeetCode 713. Subarray Product Less Than K
 *
 * Pattern:
 * Sliding Window (Variable Size)
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Variable Sliding Window
 * - Running Product
 * - Counting Subarrays
 * - Two Pointers
 *
 * Approaches:
 * 1. Brute Force
 *    - Generate every subarray.
 *    - Calculate its product.
 *
 * 2. Optimal (Variable Sliding Window)
 *    - Expand window.
 *    - Shrink while product >= k.
 *    - Count all valid subarrays ending at current index.
 *
 * Time Complexity:
 * Brute Force : O(n²)
 * Optimal     : O(n)
 *
 * Space Complexity:
 * Brute Force : O(1)
 * Optimal     : O(1)
 */

class Solution {

    // Brute Force
    public int bruteForce(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int product = 1;

            for (int j = i; j < nums.length; j++) {

                product *= nums[j];

                if (product < k) {
                    count++;
                }
            }
        }

        return count;
    }

    // Optimal (Original LeetCode Method)
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            product *= nums[right];

            while (product >= k) {

                product /= nums[left];
                left++;
            }

            // All subarrays ending at 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }
}