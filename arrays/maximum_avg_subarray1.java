// Sliding Window Approach
// Time: O(n)
// Space: O(1)
class maximum_avg_subarray1 {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        // Step 1: Calculate sum of first window
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Step 2: Initialize maxAvg using first window
        double maxAvg = sum / k;

        // Step 3: Slide the window
        for (int right = k; right < n; right++) {

            // Remove element going out of window
            sum -= nums[right - k];

            // Add new element entering window
            sum += nums[right];

            // Update maximum average
            maxAvg = Math.max(maxAvg, sum / k);
        }

        return maxAvg;
    }
}