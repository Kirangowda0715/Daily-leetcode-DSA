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
