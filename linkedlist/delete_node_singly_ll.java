/*
 * LeetCode 237 - Delete Node in a Linked List
 *
 * Problem:
 * You are given a node in a singly linked list (NOT the head).
 * Delete this node in-place.
 *
 * Example:
 * Input:  4 -> 5 -> 1 -> 9   (node = 5)
 * Output: 4 -> 1 -> 9
 *
 * ---------------------------------------------------------
 * Approach: Copy Next Node Trick
 *
 * Since we do NOT have access to the previous node,
 * we cannot delete the node in the usual way.
 *
 * Instead:
 * 1. Copy the value of the next node into the current node
 * 2. Skip the next node
 *
 * This effectively removes the next node while keeping the structure valid.
 *
 * ---------------------------------------------------------
 * Important:
 * - This method cannot delete the last node
 *   because node.next must exist.
 *
 * ---------------------------------------------------------
 * Time Complexity:  O(1)
 * Space Complexity: O(1)
 *
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public void deleteNode(ListNode node) {

        // Copy next node's value into current node
        node.val = node.next.val;

        // Skip the next node
        node.next = node.next.next;
    }
}