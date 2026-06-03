# PrefixSum

Precompute cumulative sums to answer range queries and partition problems quickly.

## When to use it

- Left/right partitions
- Total sum minus prefix
- Subarray sum equal to target

## Recognition patterns

- Store prefix frequencies in a map
- Use constant space for simple partition checks
- Remember base-case prefix 0

## Typical complexity

O(n) time with O(n) extra space for hash-based prefix sums.

## Problems in this folder

- 1. 1991 Find the Middle Index in Array
- 2. 560 Subarray Sum Equals K
- 3. 724 Pivot Index

## Interview tips

- Compute cumulative sums once and reuse them for range calculations.