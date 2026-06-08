/*
 * LeetCode 153 - Find Minimum in Rotated Sorted Array
 *
 * Pattern:
 * Binary Search
 * Modified Binary Search
 *
 * Approach:
 * Compare nums[mid] with nums[high].
 *
 * If nums[mid] > nums[high]:
 *     Minimum lies in right half.
 *
 * Else:
 *     Minimum lies in left half including mid.
 *
 * Continue until low == high.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {

                // Minimum lies in right half
                low = mid + 1;

            } else {

                // Minimum lies in left half including mid
                high = mid;
            }
        }

        return nums[low];
    }
}