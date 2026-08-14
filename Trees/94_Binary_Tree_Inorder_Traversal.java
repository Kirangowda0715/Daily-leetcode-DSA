/*
 * LeetCode 94 - Binary Tree Inorder Traversal
 *
 * Pattern: Binary Tree DFS
 * Difficulty: Easy
 * Concepts: Recursion, Stack, Tree Traversal
 *
 * Inorder:
 * Left -> Root -> Right
 *
 * Time: O(n)
 * Space: O(h) for recursion / explicit stack
 */

import java.util.*;

class Solution {

    // ---------------------------------------------------------
    // Approach 1: Recursive DFS
    // Time: O(n)
    // Space: O(h)
    // ---------------------------------------------------------
    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }

    // ---------------------------------------------------------
    // Approach 2: Iterative DFS using Stack
    // Time: O(n)
    // Space: O(h)
    // ---------------------------------------------------------
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // Go as far left as possible.
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the leftmost unprocessed node.
            current = stack.pop();
            result.add(current.val);

            // Now process the right subtree.
            current = current.right;
        }

        return result;
    }
}