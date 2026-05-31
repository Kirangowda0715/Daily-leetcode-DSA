/*
Problem: Single Number II (LeetCode 137)

Description:
Given an integer array nums where every element appears
three times except for one, which appears exactly once.

Find and return the single element.

Constraints:
- Linear runtime complexity O(n)
- Constant extra space O(1)

Approach:
Use two bit masks:
- ones -> stores bits seen exactly once
- twos -> stores bits seen exactly twice

For each number:
1. Update ones using XOR
2. Remove bits already present in twos
3. Update twos using XOR
4. Remove bits already present in ones

Bits appearing 3 times are automatically removed
from both masks.

The remaining bits in ones form the answer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {

        int ones = 0;
        int twos = 0;

        for (int num : nums) {

            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}