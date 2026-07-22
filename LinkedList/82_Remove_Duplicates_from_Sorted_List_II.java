/*
 * LeetCode 82 - Remove Duplicates from Sorted List II
 *
 * Pattern:
 * Linked List, Dummy Node, Two Pointers
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Dummy Node
 * - Pointer Manipulation
 * - Removing Consecutive Duplicate Blocks
 *
 * Approach:
 * Since the list is sorted, duplicate values occur consecutively.
 * Traverse the list using two pointers:
 * - prev: last confirmed distinct node
 * - cur : current node being examined
 *
 * When duplicates are found, skip the entire duplicate block and
 * connect prev directly to the next distinct node.
 * Otherwise, move prev forward.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {

            // Duplicate block found
            if (cur.val == cur.next.val) {

                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                // Remove entire duplicate block
                prev.next = cur.next;

            } else {
                // Current node is unique
                prev = prev.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}