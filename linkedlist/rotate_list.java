/*
Problem: Rotate List (LeetCode)

Description:
Given the head of a linked list, rotate the list to the right by k places.

Example:
Input:  head = [1 -> 2 -> 3 -> 4 -> 5], k = 2
Output: [4 -> 5 -> 1 -> 2 -> 3]

Explanation:
Rotate right by 2:
Step 1: [5 -> 1 -> 2 -> 3 -> 4]
Step 2: [4 -> 5 -> 1 -> 2 -> 3]

Optimal Approach:
- Find length of list
- Connect tail to head (make it circular)
- Find new tail at (length - k) position
- Break the circle

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and tail
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Optimize k
        k = k % length;
        if (k == 0) return head;

        // Step 3: Make circular
        tail.next = head;

        // Step 4: Find new tail
        int stepsToNewTail = length - k;
        ListNode newTail = head;

        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}