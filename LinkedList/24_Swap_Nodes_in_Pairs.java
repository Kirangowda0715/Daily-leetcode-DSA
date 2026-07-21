/*
 * LeetCode 24 - Swap Nodes in Pairs
 *
 * Pattern:
 * Linked List | Pointer Manipulation | Dummy Node
 *
 * Approach:
 * - Use a dummy node before the head to simplify swapping the first pair.
 * - Maintain three pointers:
 *      1. prev -> Node before the current pair
 *      2. curr -> First node of the pair
 *      3. next -> Second node of the pair
 * - Swap the pointers instead of node values.
 * - Move prev and curr to process the next pair.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public ListNode swapPairs(ListNode head) {

        // No swap needed for empty list or single node.
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node simplifies swapping the head pair.
        ListNode dummy = new ListNode(0, head);

        // prev points to the node before the current pair.
        ListNode prev = dummy;

        // curr is the first node of the current pair.
        ListNode curr = head;

        while (curr != null && curr.next != null) {

            // Second node of the current pair.
            ListNode next = curr.next;

            // ---------- Swap ----------
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            // --------------------------

            // Move to the next pair.
            prev = curr;
            curr = curr.next;
        }

        // New head after swapping.
        return dummy.next;
    }
}