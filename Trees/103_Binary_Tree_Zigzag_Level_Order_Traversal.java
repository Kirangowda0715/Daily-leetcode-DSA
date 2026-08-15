/*
 * LeetCode 103 - Binary Tree Zigzag Level Order Traversal
 *
 * Pattern:
 * Binary Tree + BFS + Level Order Traversal
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Queue
 * - BFS
 * - Level-by-level traversal
 * - LinkedList
 * - Direction toggle
 *
 * Approach:
 * Process the tree level by level using BFS.
 * For each level:
 *   - Left -> Right : addLast()
 *   - Right -> Left : addFirst()
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Control zigzag direction.
                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                // Children are always added normally to the BFS queue.
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            result.add(level);

            // Change direction for the next level.
            leftToRight = !leftToRight;
        }

        return result;
    }
}