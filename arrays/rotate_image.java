/*
 * LeetCode 48 - Rotate Image
 *
 * Problem:
 * Given an n x n matrix representing an image,
 * rotate the image by 90 degrees clockwise.
 *
 * The rotation must be done in-place (without using extra matrix).
 *
 * Example:
 *
 * Input:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Output:
 * 7 4 1
 * 8 5 2
 * 9 6 3
 *
 * ---------------------------------------------------------
 * APPROACH: Transpose + Reverse Rows
 *
 * Step 1: Transpose the matrix
 * Swap matrix[i][j] with matrix[j][i]
 *
 * Example:
 * 1 2 3        1 4 7
 * 4 5 6   ->   2 5 8
 * 7 8 9        3 6 9
 *
 * Step 2: Reverse each row
 *
 * 1 4 7        7 4 1
 * 2 5 8   ->   8 5 2
 * 3 6 9        9 6 3
 *
 * ---------------------------------------------------------
 * Time Complexity:  O(n²)
 * Space Complexity: O(1)
 *
 */

class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose matrix
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for(int i = 0; i < n; i++){

            int left = 0;
            int right = n - 1;

            while(left < right){

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}