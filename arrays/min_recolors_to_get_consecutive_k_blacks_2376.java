/*
 * LeetCode 2379 - Minimum Recolors to Get K Consecutive Black Blocks
 *
 * Problem:
 * Given a string consisting of:
 *   'B' = Black block
 *   'W' = White block
 *
 * Find the minimum number of recolors required
 * to obtain k consecutive black blocks.
 *
 * ---------------------------------------------------------
 * Approach:
 * Sliding Window
 *
 * Observation:
 * In any window of size k,
 * the number of white blocks equals the number
 * of recolors required.
 *
 * Therefore:
 * Answer = Minimum white count among all windows.
 *
 * ---------------------------------------------------------
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int minimumRecolors(String blocks, int k) {

        int whiteCount = 0;

        // Count whites in first window
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        int minWhiteCount = whiteCount;

        // Slide the window
        for (int i = k; i < blocks.length(); i++) {

            // Remove outgoing character
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }

            // Add incoming character
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            minWhiteCount = Math.min(minWhiteCount, whiteCount);
        }

        return minWhiteCount;
    }
}