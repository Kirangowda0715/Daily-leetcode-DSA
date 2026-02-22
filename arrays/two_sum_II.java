 /*
LeetCode 167: Two Sum II - Input Array Is Sorted

Approach: Two Pointers
- Since the array is sorted, place one pointer at the start and one at the end.
- If sum > target → decrease right pointer to reduce sum
- If sum < target → increase left pointer to increase sum

Time Complexity: O(n)
Space Complexity: O(1)

Brute Force (not used):
- Two nested loops
- Time: O(n^2), Space: O(1)
*/

class two_sum_II {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[]{i + 1, j + 1}; // 1-based index
            } 
            else if (sum > target) {
                j--;
            } 
            else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }
}

