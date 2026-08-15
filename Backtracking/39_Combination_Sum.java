import java.util.*;

/**
 * LeetCode 39 - Combination Sum
 *
 * Pattern: Backtracking / Recursion
 * Difficulty: Medium
 *
 * Concepts:
 * - Backtracking
 * - Pick / Skip recursion
 * - Unlimited reuse of elements
 * - Combination generation
 *
 * Key Idea:
 * - Pick the current candidate -> stay at the same index
 *   because the number can be reused.
 * - Skip the current candidate -> move to index + 1.
 *
 * Time Complexity:
 * - Exponential in the worst case.
 * - Depends on the number of possible combinations.
 *
 * Space Complexity:
 * - O(target) recursion/combination depth,
 *   excluding the output.
 */

class Solution {

    /**
     * Brute Force:
     * Generate possible combinations and check their sums.
     *
     * This approach does not efficiently exploit the
     * pick/skip structure of the problem.
     */
    public List<List<Integer>> bruteForce(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void generate(
            int index,
            int[] candidates,
            int target,
            List<Integer> current,
            List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // Try using the current candidate
        current.add(candidates[index]);
        generate(
                index,
                candidates,
                target - candidates[index],
                current,
                ans
        );
        current.remove(current.size() - 1);

        // Try skipping the current candidate
        generate(
                index + 1,
                candidates,
                target,
                current,
                ans
        );
    }

    /**
     * Optimal Approach: Backtracking
     *
     * Pick:
     *   Stay at the same index because elements
     *   can be used unlimited times.
     *
     * Skip:
     *   Move to the next index.
     */
    public List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        List<List<Integer>> ans = new ArrayList<>();

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
            int[] candidates,
            int target,
            List<List<Integer>> ans,
            List<Integer> current) {

        // Valid combination found
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // No candidates left
        if (index == candidates.length) {
            return;
        }

        // Pick current candidate
        // Same index -> candidate can be reused
        if (candidates[index] <= target) {

            current.add(candidates[index]);

            findCombination(
                    index,
                    candidates,
                    target - candidates[index],
                    ans,
                    current
            );

            // Backtrack
            current.remove(current.size() - 1);
        }

        // Skip current candidate
        findCombination(
                index + 1,
                candidates,
                target,
                ans,
                current
        );
    }
}