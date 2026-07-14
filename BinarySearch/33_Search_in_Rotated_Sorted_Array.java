/*
 * LeetCode 33 - Search in Rotated Sorted Array
 *
 * Pattern:
 * Modified Binary Search
 *
 * Approach:
 * At every iteration, one half of the array is guaranteed to be sorted.
 *
 * 1. Check if the left half is sorted.
 * 2. If the target lies within the sorted half, search there.
 * 3. Otherwise, search the other half.
 *
 * Important Conditions:
 *
 * Left Half Sorted:
 * nums[left] <= nums[mid]
 *
 * Target in Left Half:
 * nums[left] <= target && target < nums[mid]
 *
 * Target in Right Half:
 * nums[mid] < target && target <= nums[right]
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}