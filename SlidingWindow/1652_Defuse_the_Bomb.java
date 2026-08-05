/*
 * LeetCode 1652. Defuse the Bomb
 *
 * Pattern:
 * Sliding Window (Fixed Size) + Circular Array
 *
 * Difficulty:
 * Easy
 *
 * Concepts:
 * - Sliding Window
 * - Circular Array
 * - Modulo Arithmetic
 * - Window Sum
 *
 * Approaches:
 *
 * 1. Brute Force
 *    - For every index, calculate the sum of the next/previous |k| elements.
 *    - Time: O(n × |k|)
 *
 * 2. Optimal (Sliding Window)
 *    - Build the first window.
 *    - Slide the window by removing one element and adding one element.
 *    - Use modulo (%) to handle circular indexing.
 *
 * Time Complexity:
 * Brute Force : O(n × |k|)
 * Optimal     : O(n)
 *
 * Space Complexity:
 * Brute Force : O(1)
 * Optimal     : O(1) (excluding output array)
 */

class Solution {

    // ---------------- Brute Force ----------------
    public int[] bruteForce(int[] code, int k) {

        int n = code.length;
        int[] ans = new int[n];

        if (k == 0) {
            return ans;
        }

        for (int i = 0; i < n; i++) {

            int sum = 0;

            if (k > 0) {

                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }

            } else {

                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
            }

            ans[i] = sum;
        }

        return ans;
    }

    // ---------------- Optimal (Original LeetCode Method) ----------------
    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] ans = new int[n];

        if (k == 0) {
            return ans;
        }

        // Next k elements
        if (k > 0) {

            int sum = 0;

            // First window
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }

            // Slide window
            for (int i = 0; i < n; i++) {

                ans[i] = sum;

                sum += code[(i + k + 1) % n];
                sum -= code[(i + 1) % n];
            }
        }

        // Previous |k| elements
        else {

            k = -k;

            int sum = 0;

            // First window
            for (int i = n - k; i < n; i++) {
                sum += code[i];
            }

            // Slide window
            for (int i = 0; i < n; i++) {

                ans[i] = sum;

                sum -= code[(i - k + n) % n];
                sum += code[i];
            }
        }

        return ans;
    }
}