/*
 * LeetCode 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *
 * Pattern:
 * Sliding Window (Fixed Size)
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Fixed Sliding Window
 * - Running Sum
 * - Window Sum
 *
 * Approaches:
 * 1. Brute Force
 *    - Calculate the sum of every window separately.
 *
 * 2. Optimal (Fixed Sliding Window)
 *    - Compute the first window sum.
 *    - Slide the window by removing the outgoing element
 *      and adding the incoming element.
 *
 * Time Complexity:
 * Brute Force : O(n × k)
 * Optimal     : O(n)
 *
 * Space Complexity:
 * Brute Force : O(1)
 * Optimal     : O(1)
 */

class Solution {

    // Brute Force
    public int bruteForce(int[] arr, int k, int threshold) {

        int count = 0;

        for (int i = 0; i <= arr.length - k; i++) {

            int sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            if (sum / k >= threshold) {
                count++;
            }
        }

        return count;
    }

    // Optimal (Original LeetCode Method)
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int count = 0;
        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= k * threshold) {
            count++;
        }

        // Slide the window
        for (int i = k; i < arr.length; i++) {

            sum -= arr[i - k];
            sum += arr[i];

            if (sum >= k * threshold) {
                count++;
            }
        }

        return count;
    }
}