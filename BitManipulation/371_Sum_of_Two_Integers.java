/*
 * LeetCode 371 - Sum of Two Integers
 *
 * Pattern:
 * Bit Manipulation
 *
 * Approach:
 * Perform binary addition using bitwise operators.
 *
 * XOR (^) computes the sum without carry.
 * AND (&) finds the carry bits.
 * Shift the carry left by one position and repeat
 * until no carry remains.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {

    public int getSum(int a, int b) {

        while (b != 0) {

            // Find carry
            int carry = a & b;

            // Sum without carry
            a = a ^ b;

            // Move carry to the next bit
            b = carry << 1;
        }

        return a;
    }
}