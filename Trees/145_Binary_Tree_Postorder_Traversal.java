/*
 * LeetCode 145 - Binary Tree Postorder Traversal
 *
 * Pattern: Binary Tree DFS
 * Difficulty: Easy
 * Concepts: Recursion, Stack, Tree Traversal
 *
 * Postorder:
 * Left -> Right -> Root
 *
 * Time: O(n)
 * Space: O(h) recursive / O(n) iterative
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
        dfs(root.right, result);
        result.add(root.val);
    }

    // ---------------------------------------------------------
    // Approach 2: Iterative DFS
    //
    // Generate:
    // Root -> Right -> Left
    //
    // Reverse it:
    // Left -> Right -> Root
    //
    // Time: O(n)
    // Space: O(n)
    // ---------------------------------------------------------
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            result.add(node.val);

            // Left is pushed first.
            // Right is processed first because Stack is LIFO.
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        Collections.reverse(result);

        return result;
    }
}