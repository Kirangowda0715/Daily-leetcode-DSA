/*
 * LeetCode 189 - Rotate Array
 *
 * Problem:
 * Given an array nums, rotate the array to the right by k steps.
 *
 * Example:
 * Input:  nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * -------------------------------------------------------------
 * Approach (Reverse Technique):
 *
 * To rotate the array to the right by k steps:
 *
 * 1. Reverse the entire array.
 * 2. Reverse the first k elements.
 * 3. Reverse the remaining n-k elements.
 *
 * Why it works:
 * Reversing rearranges elements in such a way that final order
 * becomes equivalent to rotating right by k.
 *
 * Important:
 * We use k = k % n to handle cases where k > n.
 *
 * -------------------------------------------------------------
 * Time Complexity:  O(n)
 *   - Each element is visited at most once during reversal.
 *
 * Space Complexity: O(1)
 *   - In-place rotation, no extra array used.
 *
 */

class Solution {

    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // Handle cases where k > n
        k = k % n;

        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse elements between two indices
    private void reverse(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}