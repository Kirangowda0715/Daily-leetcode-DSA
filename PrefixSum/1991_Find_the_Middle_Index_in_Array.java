
/*
- LeetCode 1991 - Find the Middle Index in Array
-
- Pattern:
- Prefix Sum
-
- Approach:
- Use running sums to compare left and right partitions in one pass.
-
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

package Prefix_Sum;

public class 1991_Find_the_Middle_Index_in_Array {
    
}
/*
 * LeetCode 1991 - Find the Middle Index in Array
 *
 * Pattern:
 * Prefix Sum
 *
 * Problem:
 * Find the leftmost index such that:
 *
 * Sum of elements before the index
 * =
 * Sum of elements after the index
 *
 * If no such index exists, return -1.
 *
 * ---------------------------------------------------------
 * Intuition:
 *
 * Total Sum = Left Sum + Current Element + Right Sum
 *
 * Therefore:
 *
 * Right Sum = Total Sum - Left Sum - nums[i]
 *
 * While traversing:
 * - Maintain leftSum
 * - Compute rightSum using the formula
 * - If leftSum == rightSum, return the index
 *
 * ---------------------------------------------------------
 * Example:
 *
 * nums = [2,3,-1,8,4]
 *
 * Total Sum = 16
 *
 * At index 3:
 *
 * Left Sum  = 2 + 3 + (-1) = 4
 * Right Sum = 4
 *
 * Therefore answer = 3
 *
 * ---------------------------------------------------------
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Same Pattern:
 * - 724. Pivot Index
 * - 303. Range Sum Query
 * - 560. Subarray Sum Equals K
 *
 */

class Solution {

    public int findMiddleIndex(int[] nums) {

        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}