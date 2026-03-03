/*
    Majority Element
    ----------------
    Approach: Boyer-Moore Voting Algorithm

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {

    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        // Phase 1: Find potential candidate
        for (int num : nums) {

            // If count becomes zero, choose new candidate
            if (count == 0) {
                candidate = num;
            }

            // If same as candidate → increment count
            if (num == candidate) {
                count++;
            }
            // If different → decrement count
            else {
                count--;
            }
        }

        // Since problem guarantees majority element exists,
        // candidate is the answer.
        return candidate;
    }
}