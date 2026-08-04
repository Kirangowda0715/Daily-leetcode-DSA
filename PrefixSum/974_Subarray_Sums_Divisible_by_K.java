/*
 * LeetCode 974. Subarray Sums Divisible by K
 *
 * Pattern:
 * Prefix Sum + HashMap
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Prefix Sum
 * - HashMap
 * - Modulo Arithmetic
 * - Remainder Frequency
 *
 * Approaches:
 * 1. Brute Force
 *    - Generate every subarray and check divisibility.
 *
 * 2. Prefix Sum + HashMap (Optimal)
 *    - Store frequency of prefix sum remainders.
 *    - Same remainder => subarray divisible by k.
 *
 * Time Complexity:
 * Brute Force : O(n²)
 * Optimal     : O(n)
 *
 * Space Complexity:
 * Brute Force : O(1)
 * Optimal     : O(k) (O(n) worst case)
 */

import java.util.HashMap;

class Solution {

    // Brute Force
    public int bruteForce(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // Optimal (Original LeetCode Method)
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int preSum = 0;
        int count = 0;

        // Base case:
        // Prefix sum with remainder 0 is seen once.
        map.put(0, 1);

        for (int num : nums) {

            preSum += num;

            int rem = preSum % k;

            // Normalize negative remainder
            if (rem < 0) {
                rem += k;
            }

            // Same remainder => valid subarray
            count += map.getOrDefault(rem, 0);

            // Update frequency
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}