/*
 * LeetCode 15 - 3Sum
 *
 * Problem:
 * Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, j != k and:
 *
 *      nums[i] + nums[j] + nums[k] == 0
 *
 * Example:
 * Input:  [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2], [-1,0,1]]
 *
 * ---------------------------------------------------------
 * APPROACH 1: BRUTE FORCE
 *
 * Try all triplets (i, j, k)
 *
 * Time Complexity:  O(n^3)
 * Space Complexity: O(1)
 *
 * ---------------------------------------------------------
 * APPROACH 2: HASHING (Better)
 *
 * Fix i, use HashSet to find third element
 *
 * Time Complexity:  O(n^2)
 * Space Complexity: O(n)
 *
 * ---------------------------------------------------------
 * APPROACH 3: OPTIMAL (Two Pointers + Sorting)
 *
 * Steps:
 * 1. Sort array
 * 2. Fix one element
 * 3. Use two pointers (j, k)
 *
 * Micro Optimizations:
 * - Skip duplicates
 * - Early break if nums[i] > 0
 * - Prune impossible cases
 *
 * Time Complexity:  O(n^2)
 * Space Complexity: O(1) (excluding output)
 *
 */

import java.util.*;

class Solution {

    /* -----------------------------
       APPROACH 1: BRUTE FORCE
    ----------------------------- */
    public List<List<Integer>> threeSumBrute(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }


    /* -----------------------------
       APPROACH 2: HASHING
    ----------------------------- */
    public List<List<Integer>> threeSumBetter(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {

                int k = -(nums[i] + nums[j]);

                if (set.contains(k)) {

                    List<Integer> temp = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(temp);
                    ans.add(temp);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(ans);
    }


    /* -----------------------------
       APPROACH 3: OPTIMAL
    ----------------------------- */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Early break
            if (nums[i] > 0) break;

            // Pruning
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue;

            int j = i + 1;
            int k = n - 1;

            int a = nums[i];

            while (j < k) {

                int sum = a + nums[j] + nums[k];

                if (sum == 0) {

                    ans.add(Arrays.asList(a, nums[j], nums[k]));

                    j++;
                    k--;

                    // Skip duplicates
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }

                else if (sum < 0) {
                    j++;
                }

                else {
                    k--;
                }
            }
        }

        return ans;
    }
}