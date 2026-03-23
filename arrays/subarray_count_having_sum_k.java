/*
 * LeetCode 560 - Subarray Sum Equals K
 *
 * Problem:
 * Given an integer array nums and an integer k,
 * return the total number of subarrays whose sum equals k.
 *
 * Example:
 * Input:  nums = [1,1,1], k = 2
 * Output: 2
 *
 * ---------------------------------------------------------
 * Approach: Prefix Sum + HashMap
 *
 * Key Idea:
 * Let prefixSum[i] = sum of elements from index 0 to i
 *
 * We want:
 *     prefixSum[j] - prefixSum[i] = k
 *
 * Rearranged:
 *     prefixSum[i] = prefixSum[j] - k
 *
 * So for each index:
 * - Compute prefixSum
 * - Check if (prefixSum - k) exists in the map
 * - If yes, add its frequency to the count
 *
 * Why HashMap?
 * It stores frequency of prefix sums seen so far.
 *
 * ---------------------------------------------------------
 * Steps:
 * 1. Initialize map with (0 → 1) to handle subarrays starting from index 0
 * 2. Traverse array:
 *      - Add current element to prefixSum
 *      - Check if (prefixSum - k) exists
 *      - Add frequency to count
 *      - Update map with current prefixSum
 *
 * ---------------------------------------------------------
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 *
 */

import java.util.HashMap;

class Solution {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        // Base case: prefix sum 0 occurs once
        prefixSumCount.put(0, 1);

        for (int num : nums) {

            // Update prefix sum
            prefixSum += num;

            // Check if (prefixSum - k) exists
            int remove = prefixSum - k;

            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }

            // Store/update prefix sum frequency
            prefixSumCount.put(prefixSum,
                prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}