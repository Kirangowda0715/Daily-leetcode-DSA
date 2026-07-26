/*
 * LeetCode 540 - Single Element in a Sorted Array
 *
 * Pattern: Binary Search
 *
 * Approaches:
 * 1. Brute Force (Linear Scan)                  - O(n) Time | O(1) Space
 * 2. Optimal (Binary Search using Index Parity) - O(log n) Time | O(1) Space
 *
 * Difficulty: Medium
 *
 * Concepts:
 * - Binary Search
 * - Sorted Array
 * - Index Parity
 * - Even/Odd Pair Pattern
 */

class Solution {

    /*
     * -------------------------------------------------
     * Approach 1 : Brute Force (Linear Scan)
     * -------------------------------------------------
     *
     * Intuition:
     * Since every element appears twice except one,
     * compare each element with its adjacent elements.
     */

    public int bruteForce(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }

            else if (i == n - 1) {
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            }

            else if (nums[i] != nums[i - 1] &&
                     nums[i] != nums[i + 1]) {

                return nums[i];
            }
        }

        return -1;
    }

    /*
     * -------------------------------------------------
     * Approach 2 : Optimal (Binary Search)
     * -------------------------------------------------
     *
     * Intuition:
     * Before the single element:
     * First occurrence  -> Even Index
     * Second occurrence -> Odd Index
     *
     * After the single element,
     * this pairing pattern shifts.
     *
     * Use Binary Search to find where
     * the pairing pattern breaks.
     */

    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Pairing pattern is still valid
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {

                left = mid + 1;
            }

            // Pattern breaks here or before
            else {

                right = mid;
            }
        }

        return nums[left];
    }
}