import java.util.*;

/*
 * LeetCode 90 - Subsets II
 *
 * Pattern   : Backtracking
 * Difficulty: Medium
 * Concepts  : Subsets, Recursion, Sorting, Duplicate Handling
 *
 * Core Idea:
 * Generate all subsets using backtracking.
 *
 * Since the input may contain duplicates:
 * 1. Sort the array so duplicates become adjacent.
 * 2. Skip duplicate choices at the same recursion level.
 *
 * Important:
 *     if (i != ind && nums[i] == nums[i - 1])
 *
 * This prevents duplicate subsets while still allowing
 * duplicates at deeper levels, such as [2, 2].
 *
 * Time Complexity : O(n * 2^n) worst case
 * Space Complexity: O(n) recursion stack + output space
 */

class Solution {

    /*
     * Generates all unique subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        // Sorting places duplicates next to each other
        Arrays.sort(nums);

        findSubset(nums, 0, ans, new ArrayList<>());

        return ans;
    }

    /*
     * Backtracking function.
     *
     * ind -> starting index for the current level
     * ds  -> current subset
     */
    private void findSubset(int[] nums,
                            int ind,
                            List<List<Integer>> ans,
                            List<Integer> ds) {

        // Every state represents a valid subset
        ans.add(new ArrayList<>(ds));

        for (int i = ind; i < nums.length; i++) {

            /*
             * Skip duplicate choices at the SAME level.
             *
             * i != ind:
             * The first element at this level should always be considered.
             *
             * nums[i] == nums[i - 1]:
             * Current element is a duplicate of the previous choice.
             */
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }

            // Pick current element
            ds.add(nums[i]);

            /*
             * Move to i + 1 because nums[i] has already been used.
             */
            findSubset(nums, i + 1, ans, ds);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }
}