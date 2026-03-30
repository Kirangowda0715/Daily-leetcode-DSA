/*
Problem: Add Two Numbers (LeetCode)

Description:
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each node contains a single digit.
Add the two numbers and return the sum as a linked list.

Example:
Input:  l1 = [2 -> 4 -> 3], l2 = [5 -> 6 -> 4]
Output: [7 -> 0 -> 8]
Explanation: 342 + 465 = 807

Approach:
- Traverse both linked lists
- Add corresponding digits + carry
- Store result digit (sum % 10)
- Update carry (sum / 10)
- Use a dummy node to simplify list creation

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify result list creation
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Traverse both lists until both are null
        while (l1 != null || l2 != null) {
            int sum = carry;

            // Add value from first list if exists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from second list if exists
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate carry for next iteration
            carry = sum / 10;

            // Create new node with current digit
            current.next = new ListNode(sum % 10);

            // Move pointer forward
            current = current.next;
        }

        // If carry remains, add new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return the result (skip dummy node)
        return dummy.next;
    }
}