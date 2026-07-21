/**
 * LeetCode 104 - Maximum Depth of Binary Tree
 *
 * Approach:
 * - Use Recursive Depth First Search (DFS).
 * - Compute the maximum depth of the left and right subtrees.
 * - The current node contributes 1 to the depth.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *      h = height of the tree
 *      Worst Case : O(n)
 *      Balanced Tree : O(log n)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public int maxDepth(TreeNode root) {

        // Base Case:
        // An empty tree has depth 0.
        if (root == null) {
            return 0;
        }

        // Recursively calculate the depth of the left subtree.
        int leftDepth = maxDepth(root.left);

        // Recursively calculate the depth of the right subtree.
        int rightDepth = maxDepth(root.right);

        // Current node contributes 1 to the maximum depth.
        return 1 + Math.max(leftDepth, rightDepth);
    }
}