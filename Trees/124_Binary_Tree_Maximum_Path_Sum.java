```java
/*
 * LeetCode 124 - Binary Tree Maximum Path Sum
 *
 * Pattern:
 * Binary Tree DFS + Postorder + Tree DP
 *
 * Difficulty:
 * Hard
 *
 * Concepts:
 * - Recursion
 * - Postorder DFS
 * - Tree DP
 * - Global Maximum
 *
 * Core Idea:
 * A path through the current node can use both children:
 *
 *     left + root + right
 *
 * But the value returned to the parent can use only one side:
 *
 *     root + max(left, right)
 *
 * Negative child contributions are ignored using max(0, contribution).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {

    /*
     * Main LeetCode method.
     *
     * Integer.MIN_VALUE is required because the path
     * must contain at least one node.
     */
    public int maxPathSum(TreeNode root) {

        int[] maxsum = new int[1];
        maxsum[0] = Integer.MIN_VALUE;

        maxSum(root, maxsum);

        return maxsum[0];
    }

    /*
     * Postorder DFS.
     *
     * Returns the maximum single-side path contribution
     * that the current node can give to its parent.
     */
    public int maxSum(TreeNode root, int[] maxsum) {

        if (root == null) {
            return 0;
        }

        // Negative contribution is better ignored.
        int leftSum = Math.max(
            0,
            maxSum(root.left, maxsum)
        );

        int rightSum = Math.max(
            0,
            maxSum(root.right, maxsum)
        );

        /*
         * A complete path through the current node
         * can use both left and right contributions.
         */
        int pathThroughRoot =
            leftSum + root.val + rightSum;

        maxsum[0] = Math.max(
            maxsum[0],
            pathThroughRoot
        );

        /*
         * When returning to the parent, we can only
         * continue through ONE child.
         */
        return root.val + Math.max(leftSum, rightSum);
    }
}
```
