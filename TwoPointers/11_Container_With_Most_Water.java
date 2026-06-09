public class 11_Container_With_Most_Water {
    
}
/*
 * LeetCode 11 - Container With Most Water
 *
 * Pattern:
 * Two Pointers
 *
 * Approach:
 * Start with two pointers at both ends of the array.
 * The water stored is determined by:
 *
 * Area = min(height[left], height[right]) * (right - left)
 *
 * Since the width decreases whenever we move a pointer,
 * the only way to potentially increase the area is to
 * find a taller limiting height.
 *
 * Therefore:
 * Always move the pointer having the smaller height.
 *
 * Personal Note:
 * Solved independently using Two Pointer intuition.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;

        while (left < right) {

            int currentHeight =
                Math.min(height[left], height[right]);

            int currentWidth =
                right - left;

            int currentArea =
                currentHeight * currentWidth;

            maxWater =
                Math.max(maxWater, currentArea);

            // Move the smaller height pointer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}