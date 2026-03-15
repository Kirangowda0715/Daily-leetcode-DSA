/*
 * LeetCode 54 - Spiral Matrix
 *
 * Problem:
 * Given an m x n matrix, return all elements of the matrix
 * in spiral order.
 *
 * Example:
 *
 * Input:
 * [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]
 * ]
 *
 * Output:
 * [1,2,3,6,9,8,7,4,5]
 *
 * ---------------------------------------------------------
 * APPROACH: Boundary Traversal
 *
 * We maintain four boundaries:
 *
 * top    -> starting row
 * bottom -> ending row
 * left   -> starting column
 * right  -> ending column
 *
 * Traversal order:
 * 1. Left → Right   (top row)
 * 2. Top → Bottom   (right column)
 * 3. Right → Left   (bottom row)
 * 4. Bottom → Top   (left column)
 *
 * After each traversal, shrink the boundary.
 *
 * ---------------------------------------------------------
 * Time Complexity:  O(m × n)
 * Space Complexity: O(1) (excluding output list)
 *
 */

import java.util.*;

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        while (left <= right && top <= bottom) {

            // Traverse top row (Left → Right)
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse right column (Top → Bottom)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse bottom row (Right → Left)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column (Bottom → Top)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}