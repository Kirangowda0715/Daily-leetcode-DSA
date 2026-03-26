/*
 * LeetCode 119 - Pascal's Triangle II
 *
 * Problem:
 * Given an integer rowIndex, return the rowIndex-th row
 * of Pascal’s Triangle (0-indexed).
 *
 * Example:
 * Input:  rowIndex = 4
 * Output: [1,4,6,4,1]
 *
 * ---------------------------------------------------------
 * Approach: Combinatorics (nCr Optimized)
 *
 * Instead of using factorial:
 * nCr = n! / (r! * (n-r)!)
 *
 * We use iterative relation:
 *
 *     next = prev * (n - i) / (i + 1)
 *
 * This allows us to:
 * - Build the row in O(n)
 * - Avoid factorial (prevents overflow)
 *
 * ---------------------------------------------------------
 * Steps:
 * 1. Start with first element = 1
 * 2. Use formula to compute next elements
 * 3. Add each value to the result list
 *
 * ---------------------------------------------------------
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 *
 */

import java.util.*;

class Solution {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        long ans = 1;

        // First element is always 1
        row.add((int) ans);

        // Generate rest of the row
        for (int i = 0; i < rowIndex; i++) {

            ans = ans * (rowIndex - i);
            ans = ans / (i + 1);

            row.add((int) ans);
        }

        return row;
    }
}