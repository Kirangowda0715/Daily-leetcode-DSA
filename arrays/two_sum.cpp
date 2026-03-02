/*
 * LeetCode 1 - Two Sum
 *
 * Problem:
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Assumptions:
 * - Exactly one solution exists.
 * - You may not use the same element twice.
 *
 * Example:
 * Input:  nums = [2,7,11,15], target = 9
 * Output: [0,1]
 *
 * -------------------------------------------------------------
 * Approach: Hash Map (Complement Technique)
 *
 * For each element:
 * 1. Compute complement = target - nums[i]
 * 2. Check if complement exists in the map
 * 3. If yes, return indices
 * 4. Otherwise, store current number with its index
 *
 * -------------------------------------------------------------
 * Why This Works:
 * Instead of checking all pairs (O(n^2)),
 * we store previously seen numbers and check in O(1) average time.
 *
 * -------------------------------------------------------------
 * Time Complexity:
 * - Using unordered_map: O(n) average
 * - Using map: O(n log n)
 *
 * Space Complexity: O(n)
 *
 */

#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        // Use unordered_map for O(1) average lookup
        unordered_map<int, int> mapp;

        for (int i = 0; i < nums.size(); i++) {

            int num = nums[i];
            int complement = target - num;

            // Check if complement already exists
            if (mapp.find(complement) != mapp.end()) {
                return {mapp[complement], i};
            }

            // Store current number with index
            mapp[num] = i;
        }

        // Problem guarantees one solution,
        // but returning default in case
        return {-1, -1};
    }
};