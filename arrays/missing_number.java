/*
 * LeetCode 268 - Missing Number
 *
 * Problem:
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing.
 *
 * Example:
 * Input:  nums = [3,0,1]
 * Output: 2
 *
 * ------------------------------------------------------------
 * Approach: XOR Trick (Optimal)
 *
 * Key XOR Properties:
 * 1. a ^ a = 0
 * 2. a ^ 0 = a
 * 3. XOR is commutative and associative
 *
 * Idea:
 * - XOR all numbers from 0 to n
 * - XOR all elements in nums
 * - All common numbers cancel out
 * - The remaining number is the missing number
 *
 * Why It Works:
 * Since every number appears exactly once except the missing one,
 * XOR cancels all duplicates and leaves only the missing value.
 *
 * ------------------------------------------------------------
 * Time Complexity:  O(n)
 *   - Single pass through the array
 *
 * Space Complexity: O(1)
 *   - No extra data structures used
 *
 */

class missing_number {

    public int missingNumber(int[] nums) {

        int xor1 = 0;  // XOR of numbers from 1 to n
        int xor2 = 0;  // XOR of elements in array

        for (int i = 0; i < nums.length; i++) {

            xor2 ^= nums[i];      // XOR array elements
            xor1 ^= (i + 1);      // XOR numbers from 1 to n
        }

        // Final XOR gives the missing number
        return xor1 ^ xor2;
    }
}