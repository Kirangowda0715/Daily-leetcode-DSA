/*
 * LeetCode 704 - Binary Search
 *
 * Pattern:
 * Binary Search
 *
 * Approach:
 * Since the array is sorted, compare the target with the middle element.
 * If the target is larger, discard the left half.
 * If the target is smaller, discard the right half.
 * Repeat until the target is found or the search space becomes empty.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // Prevent integer overflow
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

        return -1;
    }
}