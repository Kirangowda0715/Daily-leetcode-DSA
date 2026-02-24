/*
 * LeetCode 28 - Find the Index of the First Occurrence in a String
 *
 * Given two strings:
 *   - haystack
 *   - needle
 *
 * Return the index of the first occurrence of needle in haystack.
 * If needle is not found, return -1.
 *
 * -------------------------------------------------------------
 * APPROACH 1: Naive Pattern Matching
 *
 * Compare characters one by one.
 * If mismatch occurs, backtrack and try next position.
 *
 * Time Complexity:  O(n * m)
 * Space Complexity: O(1)
 *
 * -------------------------------------------------------------
 * APPROACH 2: KMP Algorithm (Optimal)
 *
 * Use Longest Prefix Suffix (LPS) array to avoid rechecking characters.
 *
 * Time Complexity:  O(n + m)
 * Space Complexity: O(m)
 *
 * -------------------------------------------------------------
 * APPROACH 3: Inbuilt Method
 *
 * Use Java's indexOf() method.
 *
 * Time Complexity: Depends on JVM implementation
 * Space Complexity: O(1)
 *
 */

class first_occurance_of_string {

    /* -----------------------------
       APPROACH 1: NAIVE METHOD
    ----------------------------- */

    public int strStrNaive(String haystack, String needle) {

        if (needle.length() == 0) return 0;

        int j = 0;

        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;

                if (j == needle.length()) {
                    return i - j + 1;
                }

            } else {
                i = i - j;  // backtrack
                j = 0;
            }
        }

        return -1;
    }


    /* -----------------------------
       APPROACH 2: KMP (OPTIMAL)
    ----------------------------- */

    public int strStrKMP(String haystack, String needle) {

        if (needle.length() == 0) return 0;

        int[] lps = buildLPS(needle);

        int i = 0; // pointer for haystack
        int j = 0; // pointer for needle

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }

            } else {

                if (j > 0) {
                    j = lps[j - 1]; // jump using LPS
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    // Build Longest Prefix Suffix (LPS) array
    private int[] buildLPS(String pattern) {

        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;

            } else {

                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }


    /* -----------------------------
       APPROACH 3: INBUILT METHOD
    ----------------------------- */

    public int strStrInbuilt(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}