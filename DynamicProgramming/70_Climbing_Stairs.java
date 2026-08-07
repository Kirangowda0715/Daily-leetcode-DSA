import java.util.Arrays;

/**
 * LeetCode 70 - Climbing Stairs
 *
 * Pattern: Dynamic Programming (1D DP)
 * Difficulty: Easy
 *
 * Concepts:
 * - Fibonacci DP
 * - Recursion
 * - Memoization
 * - Tabulation
 * - Space Optimization
 *
 * Time Complexity:
 * Brute Force      : O(2^n)
 * Memoization      : O(n)
 * Tabulation       : O(n)
 * Space Optimized  : O(n)
 *
 * Space Complexity:
 * Brute Force      : O(n)
 * Memoization      : O(n)
 * Tabulation       : O(n)
 * Space Optimized  : O(1)
 */

class Solution {

    // ---------------- Brute Force ----------------
    public int bruteForce(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        return bruteForce(n - 1) + bruteForce(n - 2);
    }

    // ---------------- Memoization ----------------
    public int better(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memo(n, dp);
    }

    private int memo(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = memo(n - 1, dp) + memo(n - 2, dp);
    }

    // ---------------- Optimal (Space Optimized) ----------------
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}