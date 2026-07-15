/*
 * LeetCode 125 - Valid Palindrome
 *
 * Pattern:
 * Two Pointers
 *
 * Approach:
 * - Use two pointers, one starting from the beginning and the other from the end.
 * - Skip all non-alphanumeric characters using Character.isLetterOrDigit().
 * - Compare characters after converting both to lowercase.
 * - If any pair does not match, return false.
 * - If all valid characters match, return true.
 *
 * Key Java Methods:
 * - Character.isLetterOrDigit(char)
 * - Character.toLowerCase(char)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isPalindrome(String s) {

        if (s == null) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}