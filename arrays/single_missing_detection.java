/*
 * LeetCode 136 - Single Number
 *
 * Problem:
 * Given a non-empty array of integers nums,
 * every element appears twice except for one.
 * Find that single one.
 *
 * Example:
 * Input:  [4,1,2,1,2]
 * Output: 4
 *
 * -------------------------------------------------------------
 * APPROACH 1: Brute Force (Double Loop)
 *
 * For each element, count frequency.
 * If frequency == 1, return it.
 *
 * Time Complexity:  O(n^2)
 * Space Complexity: O(1)
 *
 * -------------------------------------------------------------
 * APPROACH 2: HashMap (Better)
 *
 * Store frequency of elements using HashMap.
 * Return element with frequency 1.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 *
 * -------------------------------------------------------------
 * APPROACH 3: XOR (Optimal)
 *
 * XOR Properties:
 * 1. a ^ a = 0
 * 2. a ^ 0 = a
 * 3. XOR is commutative & associative
 *
 * Since every element appears twice except one,
 * all duplicates cancel out.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 *
 */

import java.util.HashMap;

class Solution {

    /* -----------------------------
       APPROACH 1: BRUTE FORCE
    ----------------------------- */
    public int singleNumberBrute(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count == 1) {
                return nums[i];
            }
        }

        return -1;
    }


    /* -----------------------------
       APPROACH 2: HASHMAP
    ----------------------------- */
    public int singleNumberHashMap(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }


    /* -----------------------------
       APPROACH 3: XOR (OPTIMAL)
    ----------------------------- */
    public int singleNumber(int[] nums) {

        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}