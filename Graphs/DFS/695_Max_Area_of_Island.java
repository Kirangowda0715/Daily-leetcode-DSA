/*
 * LeetCode 695 - Max Area of Island
 *
 * Pattern   : DFS / Connected Components
 * Difficulty: Medium
 * Concepts  : Recursion, Grid Traversal, DFS
 *
 * Problem:
 * Given an m x n binary matrix, find the maximum area
 * of an island. An island consists of 1s connected
 * horizontally or vertically.
 *
 * Approaches:
 * 1. DFS + Recursion - O(m * n) time, O(m * n) stack
 * 2. BFS            - O(m * n) time, O(m * n) queue
 *
 * Optimal Approach:
 * DFS with in-place visited marking.
 */

class Solution {

    /*
     * Approach 1: DFS + Recursion
     *
     * Every unvisited 1 represents a new island.
     * DFS calculates the size of that entire island.
     *
     * Time : O(m * n)
     * Space: O(m * n) worst-case recursion stack
     */
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    int area = dfs(i, j, grid);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    /*
     * DFS returns the total number of connected land cells
     * belonging to the current island.
     */
    private int dfs(int i, int j, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Invalid cell or water.
        if (i < 0 || j < 0 ||
            i >= m || j >= n ||
            grid[i][j] == 0) {

            return 0;
        }

        // Count current land cell.
        int area = 1;

        // Mark as visited.
        grid[i][j] = 0;

        // Explore four directions.
        area += dfs(i, j - 1, grid); // Left
        area += dfs(i, j + 1, grid); // Right
        area += dfs(i - 1, j, grid); // Up
        area += dfs(i + 1, j, grid); // Down

        return area;
    }


    /*
     * Approach 2: BFS Alternative
     *
     * Uses a queue instead of recursion.
     *
     * Time : O(m * n)
     * Space: O(m * n)
     *
     * This method is included for interview knowledge.
     */
    public int bfs(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;

        int[][] directions = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
        };

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != 1) {
                    continue;
                }

                int area = 0;

                grid[i][j] = 0;
                queue.offer(new int[]{i, j});

                while (!queue.isEmpty()) {

                    int[] current = queue.poll();

                    int row = current[0];
                    int col = current[1];

                    area++;

                    for (int[] direction : directions) {

                        int newRow = row + direction[0];
                        int newCol = col + direction[1];

                        if (newRow < 0 || newCol < 0 ||
                            newRow >= m || newCol >= n ||
                            grid[newRow][newCol] == 0) {

                            continue;
                        }

                        grid[newRow][newCol] = 0;

                        queue.offer(new int[]{newRow, newCol});
                    }
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}