/*
 * LeetCode 547 - Number of Provinces
 *
 * Pattern: Graph - Connected Components
 * Difficulty: Medium
 *
 * Concepts:
 * - Graph traversal
 * - DFS
 * - Connected components
 * - Visited array
 *
 * Approach:
 * - Each province is a connected component.
 * - Start DFS from every unvisited city.
 * - Every time DFS starts, a new province is found.
 *
 * Time Complexity:
 * - O(N^2)
 *
 * Space Complexity:
 * - O(N) for visited array and recursion stack
 */

class Solution {

    /*
     * DFS Approach
     *
     * WHY:
     * A province is a connected component.
     * DFS from one unvisited city visits every city
     * belonging to that province.
     */
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int city = 0; city < n; city++) {

            // Unvisited city means a new province
            if (!visited[city]) {

                provinces++;

                dfs(city, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int city,
                     int[][] isConnected,
                     boolean[] visited) {

        visited[city] = true;

        // Check all cities connected to the current city
        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {

            if (isConnected[city][neighbour] == 1
                    && !visited[neighbour]) {

                dfs(neighbour, isConnected, visited);
            }
        }
    }
}