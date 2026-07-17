/*
 * LeetCode 20 - Valid Parentheses
 *
 * Pattern:
 * Stack
 *
 * Approach:
 * 1. Push every opening bracket onto the stack.
 * 2. For every closing bracket:
 *      - If the stack is empty -> invalid.
 *      - Pop the top element.
 *      - Check whether it matches the current closing bracket.
 * 3. After processing all characters,
 *    the stack must be empty for the string to be valid.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // Handle closing brackets
            else {

                // No matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check matching pair
                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }

        // All brackets should be matched
        return stack.isEmpty();
    }
}