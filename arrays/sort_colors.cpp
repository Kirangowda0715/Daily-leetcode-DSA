/*
 * LeetCode 75 - Sort Colors
 *
 * Problem:
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent.
 *
 * We use:
 * 0 -> Red
 * 1 -> White
 * 2 -> Blue
 *
 * You must solve this in one pass using constant extra space.
 *
 * Example:
 * Input:  [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * -------------------------------------------------------------
 * Approach: Dutch National Flag Algorithm
 *
 * We use three pointers:
 *
 * low  -> boundary for 0s
 * mid  -> current element
 * high -> boundary for 2s
 *
 * The idea is to partition the array into 3 regions:
 *
 * [ 0s | 1s | unknown | 2s ]
 *
 * Rules:
 *
 * If nums[mid] == 0:
 *      Swap with low
 *      low++
 *      mid++
 *
 * If nums[mid] == 1:
 *      mid++
 *
 * If nums[mid] == 2:
 *      Swap with high
 *      high--
 *      (Do NOT increment mid because swapped value needs checking)
 *
 * -------------------------------------------------------------
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 *
 */

#include <vector>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {

        int low = 0;
        int mid = 0;
        int high = nums.size() - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                // Place 0 in correct region
                swap(nums[mid], nums[low]);
                low++;
                mid++;

            }
            else if (nums[mid] == 1) {

                // 1 is already in correct region
                mid++;

            }
            else {

                // Place 2 in correct region
                swap(nums[mid], nums[high]);
                high--;

                // Do not increment mid here
            }
        }
    }
};