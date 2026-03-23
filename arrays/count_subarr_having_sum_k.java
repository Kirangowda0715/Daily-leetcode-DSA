/*
 * LeetCode 229 - Majority Element II
 *
 * Problem:
 * Given an integer array nums, return all elements that appear
 * more than ⌊n/3⌋ times.
 *
 * Example:
 * Input:  [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * ---------------------------------------------------------
 * Approach: Boyer-Moore Voting Algorithm (Extended)
 *
 * Key Insight:
 * - There can be at most 2 elements that appear more than n/3 times.
 *
 * Step 1: Find potential candidates
 * - Maintain two candidates (ele1, ele2) and their counts
 * - Cancel out different elements
 *
 * Step 2: Verify candidates
 * - Count occurrences of ele1 and ele2
 * - Add to result if count > n/3
 *
 * ---------------------------------------------------------
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 *
 */

import java.util.*;

class Solution {

    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        int ele1 = 0, ele2 = 0;
        int cnt1 = 0, cnt2 = 0;

        // Step 1: Find candidates
        for (int num : nums) {

            if (num == ele1) {
                cnt1++;
            }

            else if (num == ele2) {
                cnt2++;
            }

            else if (cnt1 == 0) {
                ele1 = num;
                cnt1 = 1;
            }

            else if (cnt2 == 0) {
                ele2 = num;
                cnt2 = 1;
            }

            else {
                cnt1--;
                cnt2--;
            }
        }

        // Step 2: Verify candidates
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == ele1) count1++;
            else if (num == ele2) count2++;
        }

        List<Integer> result = new ArrayList<>();

        if (count1 > n / 3) result.add(ele1);
        if (count2 > n / 3) result.add(ele2);

        return result;
    }
}