    /*
 * LeetCode 260 - Single Number III
 *
 * Problem:
 * Given an integer array nums:
 * - Every element appears twice except for two elements.
 * - Find the two elements that appear only once.
 *
 * Example:
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 *
 * -------------------------------------------------------------
 * Approach: XOR + Bit Manipulation
 *
 * Step 1:
 * XOR all elements.
 * Since duplicates cancel (a ^ a = 0),
 * the result becomes:
 *
 *      xor = num1 ^ num2
 *
 * Step 2:
 * Find a bit where num1 and num2 differ.
 * We isolate the rightmost set bit using:
 *
 *      diffBit = xor & (-xor)
 *
 * This bit helps separate numbers into two groups.
 *
 * Step 3:
 * Divide numbers into two groups:
 * - Group A: numbers where diffBit is not set
 * - Group B: numbers where diffBit is set
 *
 * Duplicates cancel inside each group.
 * The remaining numbers are the two unique numbers.
 *
 * -------------------------------------------------------------
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 *
 */

class missing_numberlll {

    public int[] singleNumber(int[] nums) {

        int xor = 0;

        // Step 1: XOR all numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Isolate rightmost set bit
        int diffBit = xor & (-xor);

        int a = 0, b = 0;

        // Step 3: Divide into two groups
        for (int num : nums) {

            if ((num & diffBit) == 0) {
                a ^= num;   // Group 1
            } else {
                b ^= num;   // Group 2
            }
        }

        return new int[]{a, b};
    }
}

