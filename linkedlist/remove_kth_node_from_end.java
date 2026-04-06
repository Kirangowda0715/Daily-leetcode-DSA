/*
Problem: Remove Nth Node From End of List (LeetCode 19)

Description:
Given the head of a linked list, remove the nth node from the end
of the list and return its head.

Example:
Input:  head = [1 -> 2 -> 3 -> 4 -> 5], n = 2
Output: [1 -> 2 -> 3 -> 5]

Approach 1 (Used Here - Length Based):
- Find total length of list
- Calculate position = length - n
- Use dummy node to handle edge cases
- Traverse to node before target
- Skip target node

Time Complexity: O(n)
Space Complexity: O(1)

Optimal Approach (Interview):
- Use two pointers (fast & slow)
- Move fast pointer n steps ahead
- Move both until fast reaches end
- Delete node at slow.next
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node to handle edge cases (like deleting head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Find length
        int length = getLength(head);

        // Step 2: Move to node before target
        ListNode current = dummy;
        for (int i = 0; i < length - n; i++) {
            current = current.next;
        }

        // Step 3: Delete node
        current.next = current.next.next;

        return dummy.next;
    }

    // Helper function to calculate length
    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}