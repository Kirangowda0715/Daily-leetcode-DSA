/*
 * LeetCode 1732. Find the Highest Altitude
 *
 * Pattern:
 * Prefix Sum (Running Sum)
 *
 * Difficulty:
 * Easy
 *
 * Concepts:
 * - Prefix Sum
 * - Running Sum
 * - Cumulative Sum
 *
 * Approaches:
 * 1. Brute Force
 *    - Build the complete altitude array.
 *    - Find the maximum altitude.
 *
 * 2. Optimal (Running Prefix Sum)
 *    - Maintain only the current altitude.
 *    - Update the maximum altitude on the fly.
 *
 * Time Complexity:
 * Brute Force : O(n)
 * Optimal     : O(n)
 *
 * Space Complexity:
 * Brute Force : O(n)
 * Optimal     : O(1)
 */

class Solution {

    // Brute Force
    public int bruteForce(int[] gain) {

        int n = gain.length;

        int[] altitude = new int[n + 1];

        altitude[0] = 0;

        int max = 0;

        for (int i = 0; i < n; i++) {

            altitude[i + 1] = altitude[i] + gain[i];

            max = Math.max(max, altitude[i + 1]);
        }

        return max;
    }

    // Optimal (Original LeetCode Method)
    public int largestAltitude(int[] gain) {

        int alt = 0;
        int maxAlt = 0;

        for (int g : gain) {

            alt += g;

            maxAlt = Math.max(maxAlt, alt);
        }

        return maxAlt;
    }
}