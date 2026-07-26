/*
 * LeetCode 941. Valid Mountain Array
 *
 * Pattern:
 * Array Traversal / Simulation
 *
 * Difficulty:
 * Easy
 *
 * Concepts:
 * - Strict Increasing
 * - Strict Decreasing
 * - Peak Validation
 * - Single Traversal
 *
 * Approaches:
 * 1. Brute Force (Check every possible peak) - O(n²)
 * 2. Optimal (Two-Phase Traversal) - O(n)
 *
 * Time Complexity:
 * Brute Force : O(n²)
 * Optimal     : O(n)
 *
 * Space Complexity:
 * O(1)
 */

class Solution {

    // Brute Force
    public boolean bruteForce(int[] arr) {
        int n = arr.length;

        if (n < 3) return false;

        for (int peak = 1; peak < n - 1; peak++) {

            boolean valid = true;

            for (int i = 1; i <= peak; i++) {
                if (arr[i] <= arr[i - 1]) {
                    valid = false;
                    break;
                }
            }

            if (!valid) continue;

            for (int i = peak + 1; i < n; i++) {
                if (arr[i] >= arr[i - 1]) {
                    valid = false;
                    break;
                }
            }

            if (valid) return true;
        }

        return false;
    }

    // Optimal (Original LeetCode Method)
    public boolean validMountainArray(int[] arr) {

        int flag1 = 0, flag2 = 0;

        if (arr.length < 3)
            return false;

        int i = 1;

        // Climb up
        while (i < arr.length && arr[i] > arr[i - 1]) {
            i++;
            flag1 = 1;
        }

        // Climb down
        while (i < arr.length && arr[i] < arr[i - 1]) {
            i++;
            flag2 = 1;
        }

        return i == arr.length && (flag1 + flag2) == 2;
    }
}