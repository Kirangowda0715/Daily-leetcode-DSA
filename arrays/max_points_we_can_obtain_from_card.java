/*
 * LeetCode 1423 - Maximum Points You Can Obtain from Cards
 *
 * Problem:
 * You can pick exactly k cards from either:
 * - The beginning of the array
 * - The end of the array
 *
 * Return the maximum score possible.
 *
 * Approach:
 * Instead of randomly picking cards,
 * observe that total picks = k.
 *
 * Possible combinations:
 * - Take k from left
 * - Take k-1 from left and 1 from right
 * - Take k-2 from left and 2 from right
 * - ...
 * - Take 0 from left and k from right
 *
 * We simulate this by:
 * 1. Taking first k elements as initial sum.
 * 2. Gradually removing one from left and adding one from right.
 * 3. Tracking the maximum sum.
 *
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 */

class max_points_we_can_obtain_from_card {

    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // Step 1: Take first k elements (all from left)
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        // Initialize maxSum with the case where we take all k from left
        int maxSum = leftSum;

        // rightSum stores elements taken from the right side
        int rightSum = 0;

        // Step 2: Shift picks one by one from left to right
        for (int i = 0; i < k; i++) {

            // Remove one element from the left side
            leftSum -= cardPoints[k - 1 - i];

            // Add one element from the right side
            rightSum += cardPoints[n - 1 - i];

            // Update maximum sum
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}