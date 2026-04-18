/*
Problem: Middle of the Linked List (LeetCode 876)

Description:
Given the head of a singly linked list, return the middle node.
If there are two middle nodes, return the second middle node.

Example:
Input:  [1 -> 2 -> 3 -> 4 -> 5]
Output: [3 -> 4 -> 5]

Approach (Optimal - Two Pointer):
- Use two pointers: slow and fast
- slow moves 1 step, fast moves 2 steps
- When fast reaches end, slow is at middle

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow will be at middle
        return slow;
    }
}