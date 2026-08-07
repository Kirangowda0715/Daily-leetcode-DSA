/*
 * LeetCode 930. Binary Subarrays With Sum
 *
 * Pattern:
 * Sliding Window (Variable Size) + At Most Technique
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Variable Sliding Window
 * - Binary Array
 * - At Most Trick
 * - Counting Subarrays
 *
 * Approaches:
 *
 * 1. Prefix Sum + HashMap
 *    - Store prefix sum frequencies.
 *    - Count previous prefix sums equal to (currentPrefix - goal).
 *
 * 2. Sliding Window (Optimal)
 *    - Count subarrays with sum <= goal.
 *    - Count subarrays with sum <= goal - 1.
 *    - Exactly(goal) = AtMost(goal) - AtMost(goal - 1)
 *
 * Time Complexity:
 * Prefix Sum + HashMap : O(n)
 * Sliding Window       : O(n)
 *
 * Space Complexity:
 * Prefix Sum + HashMap : O(n)
 * Sliding Window       : O(1)
 */

import java.util.HashMap;

class Solution {

    // ---------------------------------------------------
    // Approach 1 : Prefix Sum + HashMap
    // ---------------------------------------------------
    public int bruteForce(int[] nums, int goal) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {

            prefix += num;

            count += map.getOrDefault(prefix - goal, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    // ---------------------------------------------------
    // Approach 2 : Sliding Window (Original LeetCode Method)
    // ---------------------------------------------------
    public int numSubarraysWithSum(int[] nums, int goal) {

        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    // Returns number of subarrays having sum <= goal
    private int atMost(int[] nums, int goal) {

        if (goal < 0) {
            return 0;
        }

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > goal) {

                sum -= nums[left];
                left++;
            }

            // Every subarray ending at 'right' is valid
            count += (right - left + 1);
        }

        return count;
    }
}