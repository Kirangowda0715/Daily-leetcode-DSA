/*
- LeetCode 746 - Min Cost Climbing Stairs
-
- Pattern:
- Dynamic Programming
-
- Approach:
- Compute minimum cost for each step using dp transition dp[i] = cost[i] + min(dp[i-1], dp[i-2]).
-
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

/*
 * LeetCode 746 - Min Cost Climbing Stairs
 *
 * Approach:
 * Dynamic Programming
 *
 * dp[i] = minimum cost required to reach stair i
 *
 * Transition:
 * dp[i] = cost[i] + min(dp[i-1], dp[i-2])
 *
 * Final Answer:
 * min(dp[n-1], dp[n-2])
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < cost.length; i++) {

            int curr = cost[i] + Math.min(prev1, prev2);

            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }
}