/*
 * LeetCode 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * Pattern:
 * Sliding Window (Fixed Size)
 *
 * Difficulty:
 * Medium
 *
 * Concepts:
 * - Fixed Sliding Window
 * - Running Count
 * - Strings
 *
 * Approaches:
 * 1. Brute Force
 *    - Check every substring of length k.
 *    - Count vowels each time.
 *
 * 2. Optimal (Fixed Sliding Window)
 *    - Count vowels in the first window.
 *    - Remove outgoing character.
 *    - Add incoming character.
 *    - Update maximum count.
 *
 * Time Complexity:
 * Brute Force : O(n × k)
 * Optimal     : O(n)
 *
 * Space Complexity:
 * Brute Force : O(1)
 * Optimal     : O(1)
 */

class Solution {

    // Brute Force
    public int bruteForce(String s, int k) {

        int maxCount = 0;

        for (int i = 0; i <= s.length() - k; i++) {

            int count = 0;

            for (int j = i; j < i + k; j++) {

                if (isVowel(s.charAt(j))) {
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // Optimal (Original LeetCode Method)
    public int maxVowels(String s, int k) {

        int count = 0;

        for (int i = 0; i < k; i++) {

            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int maxCount = count;

        if (maxCount == k) {
            return k;
        }

        for (int j = k; j < s.length(); j++) {

            if (isVowel(s.charAt(j - k))) {
                count--;
            }

            if (isVowel(s.charAt(j))) {
                count++;
            }

            maxCount = Math.max(maxCount, count);

            if (maxCount == k) {
                return k;
            }
        }

        return maxCount;
    }

    private boolean isVowel(char c) {

        return c == 'a' ||
               c == 'e' ||
               c == 'i' ||
               c == 'o' ||
               c == 'u';
    }
}