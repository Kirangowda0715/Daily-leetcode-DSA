/*
 * Upper Bound using Binary Search
 *
 * Pattern:
 * Binary Search
 *
 * Definition:
 * Returns the index of the first element
 * strictly greater than the target.
 *
 * Example:
 * Array = [3,5,8,15,19]
 * Target = 8
 *
 * Upper Bound = 3
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class UpperBoundFinder {

    public int upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        int ans = arr.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Possible upper bound
            if (arr[mid] > target) {

                ans = mid;

                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}