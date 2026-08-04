/*
 * LeetCode 303. Range Sum Query - Immutable
 *
 * Pattern:
 * Prefix Sum
 *
 * Difficulty:
 * Easy
 *
 * Concepts:
 * - Prefix Sum
 * - Range Sum Query
 * - Preprocessing
 *
 * Approaches:
 * 1. Brute Force
 *    - Traverse from left to right for every query.
 *
 * 2. Prefix Sum (Optimal)
 *    - Precompute cumulative sums.
 *    - Answer each query in O(1).
 *
 * Time Complexity:
 * Brute Force:
 *   Constructor : O(1)
 *   Query       : O(n)
 *
 * Prefix Sum:
 *   Constructor : O(n)
 *   Query       : O(1)
 *
 * Space Complexity:
 * Brute Force : O(1)
 * Prefix Sum  : O(n)
 */

class NumArray {

    private int[] preSum;
    private int[] nums;

    // Brute Force
    public int bruteForce(int left, int right) {

        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }

    // Constructor (Optimal)
    public NumArray(int[] nums) {

        this.nums = nums;

        preSum = new int[nums.length];

        preSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }
    }

    // Original LeetCode Method
    public int sumRange(int left, int right) {

        if (left == 0) {
            return preSum[right];
        }

        return preSum[right] - preSum[left - 1];
    }
}