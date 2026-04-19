/*
 * LeetCode 2460 - Apply Operations to an Array
 *
 * Problem:
 * Given an array nums:
 *
 * Step 1:
 * If nums[i] == nums[i+1]:
 *   - nums[i] = nums[i] * 2
 *   - nums[i+1] = 0
 *
 * Step 2:
 * Move all zeros to the end.
 *
 * Example:
 * Input:  [1,2,2,1,1,0]
 * Output: [1,4,2,0,0,0]
 *
 * ---------------------------------------------------------
 * Approach:
 *
 * 1. Traverse array and apply merge operations
 * 2. Use two-pointer technique to shift non-zero elements forward
 *
 * ---------------------------------------------------------
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 *
 */

class Solution {

    public int[] applyOperations(int[] nums) {

        int n = nums.length;

        // Step 1: Apply operations
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Move non-zero elements forward
        int j = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] != 0){

                // swap nums[i] with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }

        return nums;
    }
}