/*
 * LeetCode 35 - Search Insert Position
 *
 * Pattern:
 * Binary Search (Lower Bound)
 *
 * Approach:
 * Perform a standard binary search.
 * - If the target is found, return its index.
 * - Otherwise, when the search space becomes empty,
 *   'left' points to the correct insertion position.
 *
 * Why return left?
 * At the end of the search:
 * - All elements before 'left' are smaller than target.
 * - All elements from 'left' onwards are greater than or equal to target.
 * Therefore, 'left' is the first valid insertion position.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Target not found.
        // 'left' is the correct insertion position.
        return left;
    }
}