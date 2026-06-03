# SlidingWindow

Maintain a window over the input to answer range or subsequence queries efficiently.

## When to use it

- Fixed-size or variable-size windows
- Maintain running sum or counts
- Expand/shrink pointers

## Recognition patterns

- Move the left pointer only when needed
- Use window sums/metrics to avoid recomputation
- Frame problems as contiguous subarrays or substrings

## Typical complexity

O(n) time for most sliding-window solutions.

## Problems in this folder

- 1. 000 Longest Subarray Sum K
- 2. 1052 Grumpy Bookstore Owner
- 3. 1423 Maximum Points You Can Obtain from Cards
- 4. 2379 Minimum Recolors to Get K Consecutive Black Blocks
- 5. 643 Maximum Average Subarray I

## Interview tips

- Convert the problem into a contiguous window on the input sequence.