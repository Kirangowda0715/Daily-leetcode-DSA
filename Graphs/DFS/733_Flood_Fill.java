/*
 * LeetCode 733 - Flood Fill
 *
 * Pattern   : DFS / Grid Traversal
 * Difficulty: Easy
 * Concepts  : Recursion, DFS, Flood Fill
 *
 * Problem:
 * Starting from (sr, sc), change every 4-directionally
 * connected pixel having the same original color to the
 * given target color.
 *
 * Approaches:
 * 1. DFS + Recursion - O(m * n) time, O(m * n) stack
 * 2. BFS            - O(m * n) time, O(m * n) queue
 */

class Solution {

    /*
     * Approach 1: DFS + Recursion
     *
     * Save the original color and recursively visit every
     * connected cell having that color.
     *
     * Time : O(m * n)
     * Space: O(m * n) worst-case recursion stack
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        // Store the original color of the starting pixel.
        int org = image[sr][sc];

        /*
         * Important edge case:
         * If original and target colors are the same,
         * no modification is required.
         *
         * It also prevents infinite recursion because
         * changing a cell would not change its value.
         */
        if (org == color) {
            return image;
        }

        dfs(sr, sc, image, org, color);

        return image;
    }

    private void dfs(int i, int j, int[][] image,
                     int org, int color) {

        int m = image.length;
        int n = image[0].length;

        /*
         * Stop when:
         * 1. Outside the grid
         * 2. Current cell does not have original color
         */
        if (i < 0 || j < 0 ||
            i >= m || j >= n ||
            image[i][j] != org) {

            return;
        }

        // Change current pixel to target color.
        image[i][j] = color;

        // Explore all four directions.
        dfs(i, j - 1, image, org, color); // Left
        dfs(i, j + 1, image, org, color); // Right
        dfs(i - 1, j, image, org, color); // Up
        dfs(i + 1, j, image, org, color); // Down
    }


    /*
     * Approach 2: BFS Alternative
     *
     * Uses a queue instead of recursive DFS.
     *
     * Time : O(m * n)
     * Space: O(m * n)
     *
     * Included for interview knowledge.
     */
    public int[][] bfs(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        int org = image[sr][sc];

        if (org == color) {
            return image;
        }

        java.util.Queue<int[]> queue =
                new java.util.LinkedList<>();

        int[][] directions = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
        };

        // Mark starting pixel and add it to queue.
        image[sr][sc] = color;
        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Ignore invalid or non-original-color cells.
                if (newRow < 0 || newCol < 0 ||
                    newRow >= m || newCol >= n ||
                    image[newRow][newCol] != org) {

                    continue;
                }

                // Mark and add to queue.
                image[newRow][newCol] = color;
                queue.offer(new int[]{newRow, newCol});
            }
        }

        return image;
    }
}