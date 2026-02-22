/*
LeetCode 1052: Grumpy Bookstore Owner

Approach: Sliding Window
Time Complexity: O(n)
Space Complexity: O(1)

Idea:
- Store number → index in map
- For each element, check if target - current exists
*/
class grumpy_bookstore_owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;
        int base = 0;

        // 1️⃣ Count already satisfied customers
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }

        // 2️⃣ Build first window (constant size = minutes)
        int windowSum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                windowSum += customers[i];
            }
        }

        int maxExtra = windowSum;

        // 3️⃣ Slide the window
        for (int i = minutes; i < n; i++) {

            // Add new element
            if (grumpy[i] == 1) {
                windowSum += customers[i];
            }

            // Remove old element
            if (grumpy[i - minutes] == 1) {
                windowSum -= customers[i - minutes];
            }

            maxExtra = Math.max(maxExtra, windowSum);
        }

        return base + maxExtra;
    }
}