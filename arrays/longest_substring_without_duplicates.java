class longest_substring_without_duplicates {
    public int lengthOfLongestSubstring(String s) {

        // Store last seen index of each character
        int[] hash = new int[256];

        // IMPORTANT: initialize with -1
        // If we don't do this, default value 0 will create false duplicate detection
        for (int i = 0; i < 256; i++) {
            hash[i] = -1;
        }

        int left = 0;      // Start of sliding window
        int maxLen = 0;    // Answer

        // right pointer expands the window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // We must check if character was seen INSIDE current window
            // hash[ch] gives last index of that character
            // If last index >= left, it means duplicate exists in current window as left is the start of current window
            if (hash[ch] >= left) {

        
                // Move left just after previous occurrence
                left = hash[ch] + 1;
            }


            // Must update using 'right'
            hash[ch] = right;

            // Calculate current window length
            int len = right - left + 1;

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}