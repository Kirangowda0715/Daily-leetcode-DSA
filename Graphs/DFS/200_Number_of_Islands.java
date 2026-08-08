package Graphs.DFS;

/*
 * LeetCode 200 - Number of Islands
 *
 * Pattern   : DFS / Graph Traversal
 * Difficulty: Medium
 * Concepts  : Recursion, Grid Traversal, Connected Components
 *
 * Approaches:
 * 1. DFS + Recursion - O(m * n) time, O(m * n) stack space
 * 2. BFS            - O(m * n) time, O(m * n) queue space
 *
 * Optimal Approach:
 * DFS with in-place visited marking.
 */

class Solution {

    /*
     * Approach 1: DFS + Recursion
     *
     * Every unvisited '1' represents a new island.
     * DFS visits the complete connected component and
     * changes visited land from '1' to '0'.
     *
     * Time : O(m * n)
     * Space: O(m * n) worst-case recursion stack
     */
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {

                    // Found a new island.
                    count++;

                    // Consume the entire connected island.
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Outside the grid or water.
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }

        // Mark current land as visited.
        // This prevents revisiting and infinite recursion.
        grid[i][j] = '0';

        // Explore all four possible directions.
        dfs(i, j - 1, grid); // Left
        dfs(i, j + 1, grid); // Right
        dfs(i - 1, j, grid); // Up
        dfs(i + 1, j, grid); // Down
    }


    /*
     * Approach 2: BFS Alternative
     *
     * Same connected-component idea, but uses a queue
     * instead of the recursive call stack.
     *
     * Time : O(m * n)
     * Space: O(m * n)
     *
     * Kept here for interview knowledge.
     */
    public int bfs(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        int[][] directions = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
        };

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != '1') {
                    continue;
                }

                count++;

                // Mark immediately when adding to queue.
                grid[i][j] = '0';
                queue.offer(new int[]{i, j});

                while (!queue.isEmpty()) {

                    int[] current = queue.poll();

                    int row = current[0];
                    int col = current[1];

                    for (int[] direction : directions) {

                        int newRow = row + direction[0];
                        int newCol = col + direction[1];

                        if (newRow < 0 || newCol < 0 ||
                            newRow >= m || newCol >= n ||
                            grid[newRow][newCol] == '0') {
                            continue;
                        }

                        grid[newRow][newCol] = '0';
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return count;
    }
}