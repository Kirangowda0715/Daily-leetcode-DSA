/*
Problem: Convert Binary Number in a Linked List to Integer (LeetCode 1290)

Description:
Given a linked list where each node contains either 0 or 1,
representing a binary number, return its decimal value.

Example:
Input:
1 -> 0 -> 1

Binary:
101

Output:
5

Approach:
- Traverse the linked list from head.
- Maintain a running decimal value.
- For each node:
    decimal = decimal * 2 + currentBit
- Multiplying by 2 shifts all previous bits left by one position.
- Adding the current bit appends it to the binary number.

Time Complexity: O(n)
Space Complexity: O(1)

Personal Achievement:
Solved independently without referring to any similar solution.
*/

class Solution {

    public int getDecimalValue(ListNode head) {

        int sum = 0;

        while (head != null) {

            // Left shift previous bits
            sum *= 2;

            // Add current bit
            sum += head.val;

            head = head.next;
        }

        return sum;
    }
}