/*
 * LeetCode 242 - Valid Anagram
 *
 * Pattern:
 * Hashing / Frequency Counting
 *
 * Approach:
 * Since the problem specifies lowercase English letters,
 * use a frequency array of size 26.
 *
 * Increment the frequency for characters in the first string.
 * Decrement the frequency for characters in the second string.
 *
 * If every frequency becomes zero,
 * the two strings are anagrams.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int frequency : count) {
            if (frequency != 0) {
                return false;
            }
        }

        return true;
    }
}