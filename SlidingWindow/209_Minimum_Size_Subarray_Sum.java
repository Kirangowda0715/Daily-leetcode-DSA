    /*
 * LeetCode 209. Minimum Size Subarray Sum
 *
 * Pattern:
 * Sliding Window (Variable Size)
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Variable Sliding Window
 * - Two Pointers
 * - Positive Numbers
 *
 * Approaches:
 * 1. Brute Force
 *    - Check every possible subarray.
 *
 * 2. Optimal (Variable Sliding Window)
 *    - Expand the window until sum >= target.
 *    - Shrink the window to find the minimum valid length.
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
    public int bruteForce(int target, int[] nums) {

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                if (sum >= target) {

                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // Optimal (Original LeetCode Method)
    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                minLen = Math.min(minLen, right - left + 1);

                sum -= nums[left];

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

