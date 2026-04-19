/*
Problem: Linked List Cycle (LeetCode 141)

Description:
Given the head of a linked list, determine if there is a cycle in it.
Return true if there is a cycle, otherwise return false.

Approach (Floyd’s Cycle Detection Algorithm):
- Use two pointers: slow and fast
- slow moves 1 step, fast moves 2 steps
- If a cycle exists, they will meet
- If fast reaches null, no cycle exists

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {

            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            // Cycle detected
            if (slow == fast) {
                return true;
            }
        }

        // No cycle
        return false;
    }
}
