/*
 * LeetCode 73 - Set Matrix Zeroes
 *
 * Problem:
 * Given an m x n matrix, if an element is 0,
 * set its entire row and column to 0.
 *
 * The operation must be done in-place.
 *
 * Example:
 *
 * Input:
 * [
 *  [1,1,1],
 *  [1,0,1],
 *  [1,1,1]
 * ]
 *
 * Output:
 * [
 *  [1,0,1],
 *  [0,0,0],
 *  [1,0,1]
 * ]
 *
 * ---------------------------------------------------------
 * APPROACH 1: Using Extra Arrays (Better Approach)
 *
 * Idea:
 * - Maintain two arrays to mark rows and columns containing zero.
 * - row[i] = 1 → entire row must become zero
 * - col[j] = 1 → entire column must become zero
 *
 * Steps:
 * 1. Traverse matrix and mark rows/columns containing 0
 * 2. Traverse matrix again and update cells
 *
 * Time Complexity:  O(n * m)
 * Space Complexity: O(n + m)
 *
 * ---------------------------------------------------------
 * APPROACH 2: Optimal Approach (Constant Space)
 *
 * Idea:
 * Use the first row and first column of the matrix as markers.
 *
 * If matrix[i][j] == 0:
 *      matrix[i][0] = 0
 *      matrix[0][j] = 0
 *
 * We also track whether the first column should be zero using a variable (col0).
 *
 * Time Complexity:  O(n * m)
 * Space Complexity: O(1)
 *
 */

class Solution {

    /* -----------------------------
       APPROACH 1: USING EXTRA SPACE
    ----------------------------- */
    public void setZeroesBetter(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        // Mark rows and columns containing zero
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Update matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }


    /* -----------------------------
       APPROACH 2: OPTIMAL SOLUTION
    ----------------------------- */
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;

        // Mark rows and columns
        for(int i = 0; i < n; i++){

            if(matrix[i][0] == 0)
                col0 = 0;

            for(int j = 1; j < m; j++){

                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Traverse backwards to update matrix
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 1; j--){

                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }

            if(col0 == 0){
                matrix[i][0] = 0;
            }
        }
    }
}