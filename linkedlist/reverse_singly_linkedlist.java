/*
Problem: Reverse Linked List (LeetCode 206)

Description:
Given the head of a singly linked list, reverse the list and return the new head.

Example:
Input:  [1 -> 2 -> 3 -> 4 -> 5]
Output: [5 -> 4 -> 3 -> 2 -> 1]

Approach (Iterative - Optimal):
- Use three pointers: prev, curr, next
- Reverse links one by one
- Move pointers forward
- Return prev as new head

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode reverseList(ListNode head) {

        // Initialize pointers
        ListNode prev = null;
        ListNode curr = head;

        // Traverse the list
        while (curr != null) {

            // Store next node
            ListNode next = curr.next;

            // Reverse current node's pointer
            curr.next = prev;

            // Move pointers forward
            prev = curr;
            curr = next;
        }

        // prev becomes new head
        return prev;
    }
}