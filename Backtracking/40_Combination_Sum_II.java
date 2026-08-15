import java.util.*;

/**
 * LeetCode 40 - Combination Sum II
 *
 * Pattern: Backtracking
 * Difficulty: Medium
 *
 * Concepts:
 * - Backtracking
 * - For-loop recursion
 * - Sorting
 * - Duplicate handling
 * - Each element used at most once
 *
 * Key Difference from Combination Sum I:
 * - Combination Sum I  -> recurse with i
 * - Combination Sum II -> recurse with i + 1
 *
 * Duplicate Handling:
 * if (i > index && arr[i] == arr[i - 1])
 *     continue;
 *
 * This skips duplicate choices at the same recursion level
 * while still allowing duplicate values in a combination.
 *
 * Time Complexity:
 * - O(2^n) worst case, excluding output
 * - Sorting: O(n log n)
 *
 * Space Complexity:
 * - O(n) recursion depth, excluding output
 */

class Solution {

    /**
     * Brute Force:
     * Generate all possible subsets and check their sums.
     *
     * This does not efficiently handle duplicate combinations,
     * so it is mainly useful for understanding the problem.
     */
    public List<List<Integer>> bruteForce(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        generate(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void generate(
            int index,
            int[] arr,
            int target,
            List<Integer> current,
            List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        // Pick current element
        current.add(arr[index]);

        generate(
                index + 1,
                arr,
                target - arr[index],
                current,
                ans
        );

        current.remove(current.size() - 1);

        // Skip current element
        generate(
                index + 1,
                arr,
                target,
                current,
                ans
        );
    }

    /**
     * Optimal Approach:
     * Backtracking with a for loop.
     *
     * Important:
     * - i + 1 -> element cannot be reused
     * - i > index && arr[i] == arr[i - 1]
     *   -> skip duplicate choices at the same level
     */
    public List<List<Integer>> combinationSum2(
            int[] candidates,
            int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        findCombination(
                0,
                candidates,
                target,
                ans,
                new ArrayList<>()
        );

        return ans;
    }

    private void findCombination(
            int index,
            int[] arr,
            int target,
            List<List<Integer>> ans,
            List<Integer> current) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Skip duplicate choices at the same level
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            // Array is sorted, so later elements will also be too large
            if (arr[i] > target) {
                break;
            }

            // Choose
            current.add(arr[i]);

            // i + 1 -> each element can be used only once
            findCombination(
                    i + 1,
                    arr,
                    target - arr[i],
                    ans,
                    current
            );

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}