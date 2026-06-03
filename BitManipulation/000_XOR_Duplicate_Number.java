
/*
- XOR Duplicate Number
-
- Pattern:
- Bit Manipulation
-
- Approach:
- Use frequency and XOR to extract the duplicated value from the array.
-
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

public class xor_of_num_appear_twice {
    public int duplicateNumbersXOR(int[] nums) {

        int[] freq = new int[51];  // because nums[i] <= 50
        int xor = 0;

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i <= 50; i++) {
            if (freq[i] == 2) {
                xor ^= i;
            }
        }

        return xor;
    }

}
