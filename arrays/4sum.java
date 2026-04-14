/*
 * LeetCode 18 - 4Sum
 *
 * Problem:
 * Given an array nums and an integer target,
 * return all unique quadruplets [nums[i], nums[j], nums[k], nums[l]]
 * such that:
 *
 *      nums[i] + nums[j] + nums[k] + nums[l] == target
 *
 * Example:
 * Input:  nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * ---------------------------------------------------------
 * Approach: Sorting + Two Pointers (Striver Optimized)
 *
 * Idea:
 * - Sort the array
 * - Fix two elements (i, j)
 * - Use two pointers (k, l) for remaining two
 *
 * Optimizations:
 * - Skip duplicates for i, j, k, l
 * - Prune impossible cases using min/max sums
 * - Use long to prevent integer overflow
 *
 * ---------------------------------------------------------
 * Time Complexity:  O(n^3)
 * Space Complexity: O(1) (excluding output)
 *
 */

import java.util.*;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Pruning: smallest possible sum > target
            long min1 = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) break;

            // Pruning: largest possible sum < target
            long max1 = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (max1 < target) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Pruning for j
                long min2 = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min2 > target) break;

                long max2 = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (max2 < target) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {

                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        k++;
                        l--;

                        // Skip duplicates for k
                        while (k < l && nums[k] == nums[k - 1]) k++;

                        // Skip duplicates for l
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }

                    else if (sum < target) {
                        k++;
                    }

                    else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }
}