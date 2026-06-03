
/*
- LeetCode 724 - Find Pivot Index
-
- Pattern:
- Prefix Sum
-
- Approach:
- Maintain total and left sums to compare left and right partitions.
-
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

/*
 * LeetCode 724 - Find Pivot Index
 *
 * Pattern:
 * Prefix Sum
 *
 * Problem:
 * Find an index such that:
 *
 * Sum of elements on the left
 * =
 * Sum of elements on the right
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
 * - If both are equal, return index
 *
 * ---------------------------------------------------------
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 */

class Solution {

    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        // Calculate total sum of array
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