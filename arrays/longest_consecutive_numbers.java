/*
 * LeetCode 128 - Longest Consecutive Sequence
 *
 * Problem:
 * Given an unsorted array of integers nums,
 * return the length of the longest consecutive elements sequence.
 *
 * Example:
 * Input:  nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest sequence is [1,2,3,4]
 *
 * ---------------------------------------------------------
 * APPROACH 1: Brute Force
 *
 * For each number, check if num+1, num+2, ... exists
 * by scanning the entire array.
 *
 * Time Complexity:  O(n^2)
 * Space Complexity: O(1)
 *
 * ---------------------------------------------------------
 * APPROACH 2: Sorting (Better Approach)
 *
 * Steps:
 * 1. Sort the array
 * 2. Count consecutive elements
 * 3. Skip duplicates
 *
 * Time Complexity:  O(n log n)
 * Space Complexity: O(1)
 *
 * ---------------------------------------------------------
 * APPROACH 3: HashSet (Optimal Approach)
 *
 * Key Idea:
 * A number starts a sequence only if (num - 1) is NOT present.
 *
 * Example:
 * nums = [100,4,200,1,3,2]
 *
 * Start from 1 because 0 doesn't exist.
 * Sequence: 1 → 2 → 3 → 4
 *
 * Each sequence is built only once.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 *
 */

import java.util.*;

class Solution {

    /* -----------------------------
       APPROACH 2: SORTING METHOD
    ----------------------------- */
    public int longestConsecutiveSorting(int[] nums) {

        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int longest = 1;
        int count = 1;

        for(int i = 1; i < nums.length; i++){

            if(nums[i] == nums[i - 1]){
                continue; // skip duplicates
            }

            else if(nums[i] == nums[i - 1] + 1){
                count++;
            }

            else{
                count = 1;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }


    /* -----------------------------
       APPROACH 3: OPTIMAL HASHSET
    ----------------------------- */
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        for(int num : set){

            // start of sequence
            if(!set.contains(num - 1)){

                int current = num;
                int count = 1;

                while(set.contains(current + 1)){
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}