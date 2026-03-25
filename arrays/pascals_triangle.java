/*
 * LeetCode 118 - Pascal's Triangle
 *
 * Problem:
 * Given an integer numRows, return the first numRows of Pascal's Triangle.
 *
 * Example:
 * Input:  numRows = 5
 * Output:
 * [
 *  [1],
 *  [1,1],
 *  [1,2,1],
 *  [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * ---------------------------------------------------------
 * STRIVER APPROACH (3 PARTS)
 *
 * 1️⃣ Find element at (row, col) using nCr
 * 2️⃣ Generate entire row
 * 3️⃣ Generate full Pascal Triangle
 *
 * ---------------------------------------------------------
 * Time Complexity:
 * - Single row: O(n)
 * - Full triangle: O(n^2)
 *
 * Space Complexity:
 * - O(n^2) for storing result
 *
 */

import java.util.*;

class Solution {

    /* -----------------------------
       1️⃣ FIND nCr (Single Element)
    ----------------------------- */
    public int nCr(int n, int r) {

        long res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return (int) res;
    }


    /* -----------------------------
       2️⃣ GENERATE SINGLE ROW
    ----------------------------- */
    public List<Integer> generateRow(int N) {

        List<Integer> row = new ArrayList<>();

        int ans = 1;
        row.add(ans);

        for (int i = 1; i < N; i++) {
            ans = ans * (N - i);
            ans = ans / i;
            row.add(ans);
        }

        return row;
    }


    /* -----------------------------
       3️⃣ GENERATE FULL TRIANGLE
    ----------------------------- */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            result.add(generateRow(i));
        }

        return result;
    }
}