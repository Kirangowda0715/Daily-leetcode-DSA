/*
Problem: Remove Linked List Elements (LeetCode 203)

Description:
Given the head of a linked list and an integer val,
remove all nodes whose value equals val and return
the updated linked list.

Example:
Input:
head = [1,2,6,3,4,5,6]
val = 6

Output:
[1,2,3,4,5]

Approach:
- Create a dummy node before head.
- Traverse the list using two pointers:
    prev -> previous valid node
    cur  -> current node
- If current node contains the target value,
  skip it by changing prev.next.
- Otherwise move prev forward.
- Always move cur forward.

Why Dummy Node?
It handles deletion of the head node without requiring
special-case logic.

Time Complexity: O(n)
Space Complexity: O(1)

Personal Achievement:
Solved independently without referring to any similar solution.
*/

class Solution {

    public ListNode removeElements(ListNode head, int val) {

        // Dummy node simplifies deletion at head
        ListNode dummy = new ListNode(0, head);

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {

            // Delete current node
            if (cur.val == val) {
                prev.next = cur.next;
            }
            // Keep current node
            else {
                prev = cur;
            }

            // Move to next node
            cur = cur.next;
        }

        return dummy.next;
    }
}