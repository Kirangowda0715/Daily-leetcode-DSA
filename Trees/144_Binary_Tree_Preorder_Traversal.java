/*
 * LeetCode 144 - Binary Tree Preorder Traversal
 *
 * Pattern: Binary Tree DFS
 * Difficulty: Easy
 * Concepts: Recursion, Stack, Tree Traversal
 *
 * Preorder:
 * Root -> Left -> Right
 *
 * Time: O(n)
 * Space: O(h) recursive / O(n) worst-case iterative
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

        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }

    // ---------------------------------------------------------
    // Approach 2: Iterative DFS using Stack
    //
    // Push right first and left second because Stack is LIFO.
    // This ensures left is processed before right.
    //
    // Time: O(n)
    // Space: O(n) worst-case
    // ---------------------------------------------------------
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}