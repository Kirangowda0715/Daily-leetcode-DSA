/*
Problem: Build an Array With Stack Operations (LeetCode 1441)

Description:
Given a strictly increasing array `target` and an integer `n`,
simulate building the array using:
- "Push" → add element
- "Pop"  → remove last element

Numbers are taken sequentially from 1 to n.

Example:
Input:  target = [1, 3], n = 3
Output: ["Push", "Push", "Pop", "Push"]

Approach:
- Traverse numbers from 1 to n
- Compare with target[k]
- If equal → Push and move pointer
- If not → Push + Pop
- Stop once target is fully built

Time Complexity: O(n)
Space Complexity: O(1) (excluding output)
*/

import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int k = 0;

        for (int i = 1; i <= n; i++) {
            if (k == target.length) break;

            if (i == target[k]) {
                result.add("Push");
                k++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }

        return result;
    }
}