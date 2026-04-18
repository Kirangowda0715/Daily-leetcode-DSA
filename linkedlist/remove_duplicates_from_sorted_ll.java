/*
Problem: Remove Duplicates from Sorted List (LeetCode 83)

Description:
Given the head of a sorted linked list, delete all duplicates
such that each element appears only once.

Example:
Input:  [1 -> 1 -> 2 -> 3 -> 3]
Output: [1 -> 2 -> 3]

Approach:
- Traverse the list using one pointer
- Compare current node with next node
- If equal → skip the duplicate node
- Else → move forward

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // skip duplicate
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}