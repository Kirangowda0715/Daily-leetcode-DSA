# Pattern Guide

## Arrays

**Recognition:**

- In-place array updates
- Rotations and reordering
- Simple scan/multiple pointers

**Core Idea:**

Fundamental array manipulation techniques and general-purpose array problems.

**Common interview tricks:**

- Use index arithmetic carefully
- Watch boundary conditions
- Prefer in-place solutions when possible

**Complexity insight:**

O(n) or O(n^2) depending on problem specifics.

**Problems in repository:**

- 169 Majority Element
- 189 Rotate Array
- 229 Majority Element II
- 2460 Apply Operations to an Array

## Hashing

**Recognition:**

- Count frequencies
- Lookup complements
- Track seen values

**Core Idea:**

Use hash maps, hash sets, or frequency tables to speed up lookups and counts.

**Common interview tricks:**

- Initialize base cases explicitly
- Choose the right hash key
- Use maps for prefix-sum frequency counting

**Complexity insight:**

O(n) average time, O(n) space.

**Problems in repository:**

- 000 Hashing Demo
- 000 Hashing Demo
- 001 Two Sum
- 001 Two Sum
- 128 Longest Consecutive Sequence

## SlidingWindow

**Recognition:**

- Fixed-size or variable-size windows
- Maintain running sum or counts
- Expand/shrink pointers

**Core Idea:**

Maintain a window over the input to answer range or subsequence queries efficiently.

**Common interview tricks:**

- Move the left pointer only when needed
- Use window sums/metrics to avoid recomputation
- Frame problems as contiguous subarrays or substrings

**Complexity insight:**

O(n) time for most sliding-window solutions.

**Problems in repository:**

- 000 Longest Subarray Sum K
- 1052 Grumpy Bookstore Owner
- 1423 Maximum Points You Can Obtain from Cards
- 2379 Minimum Recolors to Get K Consecutive Black Blocks
- 643 Maximum Average Subarray I

## TwoPointers

**Recognition:**

- Sorted input
- Pair sums
- Opposite-end scanning
- Duplicate skipping

**Core Idea:**

Pair two indices to search for combinations or reorder data efficiently.

**Common interview tricks:**

- Advance pointers based on comparison
- Use sorted order to prune options
- Avoid repeated work with duplicate checks

**Complexity insight:**

O(n log n) if sorting is required, otherwise O(n).

**Problems in repository:**

- 075 Sort Colors
- 15 3Sum
- 167 Two Sum II Input Array Is Sorted
- 18 4Sum

## PrefixSum

**Recognition:**

- Left/right partitions
- Total sum minus prefix
- Subarray sum equal to target

**Core Idea:**

Precompute cumulative sums to answer range queries and partition problems quickly.

**Common interview tricks:**

- Store prefix frequencies in a map
- Use constant space for simple partition checks
- Remember base-case prefix 0

**Complexity insight:**

O(n) time with O(n) extra space for hash-based prefix sums.

**Problems in repository:**

- 1991 Find the Middle Index in Array
- 560 Subarray Sum Equals K
- 724 Pivot Index

## BitManipulation

**Recognition:**

- XOR cancellation
- Bit masks
- Isolate rightmost set bit
- Count set bits

**Core Idea:**

Use bitwise operations to solve number and parity problems with constant space.

**Common interview tricks:**

- Use XOR to cancel pairs
- Separate numbers by a differing bit
- Track counts with bit masks

**Complexity insight:**

O(n) time, O(1) space.

**Problems in repository:**

- 000 XOR Duplicate Number
- 136 Single Number
- 137 Single Number II
- 260 Single Number III
- 268 Missing Number

## DynamicProgramming

**Recognition:**

- Optimal substructure
- State transitions
- Overlapping subproblems

**Core Idea:**

Solve problems by reusing prior subproblem results in a table or rolling variables.

**Common interview tricks:**

- Start with base cases
- Use iterative DP when recursion is not needed
- Compress space when possible

**Complexity insight:**

Typically O(n) or O(n^2) time, depending on state size.

**Problems in repository:**

- 746 Min Cost Climbing Stairs

## LinkedList

**Recognition:**

- Slow/fast pointers
- Dummy nodes
- Node insertion/deletion
- Circular lists

**Core Idea:**

Apply pointer manipulation techniques to solve linked list problems efficiently.

**Common interview tricks:**

- Use dummy head for edge cases
- Keep multiple pointers for relative positions
- Remember null checks

**Complexity insight:**

O(n) time for most operations, O(1) extra space.

**Problems in repository:**

- 000 Doubly Linked List Basics
- 000 Doubly Linked List Basics
- 000 Singly Linked List Basics
- 002 Add Two Numbers
- 019 Remove Nth Node From End of List
- 061 Rotate List
- 083 Remove Duplicates from Sorted List
- 141 Linked List Cycle
- 206 Reverse Linked List
- 237 Delete Node in a Linked List
- 876 Middle of the Linked List

## Stack

**Recognition:**

- Push/pop sequence
- Stack simulation problems
- Output construction constraints

**Core Idea:**

Use stack operations to model last-in-first-out behavior and simulate sequence generation.

**Common interview tricks:**

- Simulate operations carefully
- Stop when target is achieved
- Use stack behavior to validate sequences

**Complexity insight:**

O(n) time and O(n) space in most stack simulation problems.

**Problems in repository:**

- 1441 Build an Array With Stack Operations

## Queue

**Recognition:**

- First-in-first-out
- Processing elements in arrival order
- Level-order scanning

**Core Idea:**

Use FIFO structures for order-preserving processing and level-order traversals.

**Common interview tricks:**

- Use queue for sliding windows and BFS-style traversal
- Track size boundaries for batch processing

**Complexity insight:**

O(n) time and O(n) space.

**Problems in repository:**

- None yet

## BinarySearch

**Recognition:**

- Sorted input
- Finding boundaries
- Search over answer space

**Core Idea:**

Narrow the search range based on sorted order or monotonic properties.

**Common interview tricks:**

- Use mid careful rounding
- Check for off-by-one while adjusting bounds
- Binary search on value rather than index for optimization problems

**Complexity insight:**

O(log n) time.

**Problems in repository:**

- None yet

## Recursion

**Recognition:**

- Recursive definitions
- Tree-like exploration
- Divide and conquer

**Core Idea:**

Solve problems by breaking them down into smaller, self-similar subproblems.

**Common interview tricks:**

- Use base cases early
- Use helper functions to pass state
- Watch recursion depth

**Complexity insight:**

Depends on branching factor and depth; often exponential without memoization.

**Problems in repository:**

- None yet

## Backtracking

**Recognition:**

- Permutation/combinations
- Constraint checking
- Depth-first exploration

**Core Idea:**

Explore choices recursively and backtrack when a path fails.

**Common interview tricks:**

- Prune early
- Use swap-based generation for permutations
- Track used states with arrays or sets

**Complexity insight:**

Often exponential in worst-case scenarios.

**Problems in repository:**

- None yet

## Greedy

**Recognition:**

- One-pass decisions
- Optimal substructure without backtracking
- Reordering to satisfy constraints

**Core Idea:**

Make locally optimal choices to build a global solution efficiently.

**Common interview tricks:**

- Identify the greedy choice property
- Use pointers to implement one-pass greedy updates
- Validate with small examples

**Complexity insight:**

O(n) time for most greedy solutions.

**Problems in repository:**

- 2149 Rearrange Array Elements by Sign

## Trees

**Recognition:**

- Nodes with children
- Recursive subtree processing
- Depth-first or breadth-first orders

**Core Idea:**

Use tree traversal and recursion for hierarchical data structures.

**Common interview tricks:**

- Use helper functions to return subtree results
- Choose pre/in/post-order based on problem
- Avoid redundant traversals

**Complexity insight:**

O(n) time for tree traversal problems.

**Problems in repository:**

- None yet

## BST

**Recognition:**

- Left < root < right
- Inorder sorted output
- Search space reduction

**Core Idea:**

Exploit binary search tree invariants to search, insert, and validate efficiently.

**Common interview tricks:**

- Use recursion with bounds
- Leverage sorted-order properties
- Track predecessor/successor for validation and deletion

**Complexity insight:**

O(h) time, where h is tree height.

**Problems in repository:**

- None yet

## Heap

**Recognition:**

- Maintain largest/smallest elements
- Kth element problems
- Streaming data summaries

**Core Idea:**

Use priority queues to solve top-k and order-statistics problems efficiently.

**Common interview tricks:**

- Use min-heap for top-k largest and max-heap for top-k smallest
- Keep heap size bounded
- Aggregate results dynamically

**Complexity insight:**

O(n log k) in many heap-based solutions.

**Problems in repository:**

- None yet

## Graphs

**Recognition:**

- Adjacency lists
- Visited marking
- Cycle detection

**Core Idea:**

Model relationships between nodes and traverse with BFS/DFS or shortest-path techniques.

**Common interview tricks:**

- Use BFS for shortest paths in unweighted graphs
- Use DFS for connectivity and cycle checks
- Convert grid problems into graph problems when needed

**Complexity insight:**

O(V + E) time for standard graph traversals.

**Problems in repository:**

- None yet

## Trie

**Recognition:**

- Prefix queries
- Character-by-character traversal
- Word insertion and lookup

**Core Idea:**

Build prefix trees for efficient string prefix search and dictionary operations.

**Common interview tricks:**

- Use nodes with children maps or arrays
- Mark word endings explicitly
- Traverse according to string characters

**Complexity insight:**

O(length of word) per operation.

**Problems in repository:**

- None yet

## SegmentTree

**Recognition:**

- Range queries
- Point updates
- Merge segments

**Core Idea:**

Use tree-based range query data structures for efficient interval operations.

**Common interview tricks:**

- Build tree bottom-up
- Use lazy propagation for range updates
- Map array indices to tree nodes

**Complexity insight:**

O(log n) per query/update.

**Problems in repository:**

- None yet

## DisjointSet

**Recognition:**

- Union and find operations
- Cycle detection in graphs
- Group connectivity queries

**Core Idea:**

Use union-find to manage connected components and equivalence relations.

**Common interview tricks:**

- Use path compression and union by rank
- Translate relationships into union-find operations

**Complexity insight:**

Nearly O(1) amortized per operation.

**Problems in repository:**

- None yet

## Strings

**Recognition:**

- Substring search
- Sliding windows over strings
- Character frequency tracking

**Core Idea:**

Solve string matching and manipulation problems with character and substring techniques.

**Common interview tricks:**

- Use KMP for pattern matching
- Use last-seen indexes for sliding windows
- Normalize strings before comparison

**Complexity insight:**

O(n) or O(n + m) for most string problems.

**Problems in repository:**

- 003 Longest Substring Without Repeating Characters
- 028 Find the Index of the First Occurrence in a String

## MathAndCombinatorics

**Recognition:**

- Binomial coefficients
- Pascal's Triangle
- Modulo arithmetic

**Core Idea:**

Solve arithmetic and combinatorial problems with formula-based methods.

**Common interview tricks:**

- Use iterative nCr computation to avoid factorial overflow
- Generate sequences one row at a time

**Complexity insight:**

O(n^2) or O(n) depending on the problem.

**Problems in repository:**

- 118 Pascals Triangle
- 119 Pascals Triangle II

## Matrix

**Recognition:**

- In-place matrix updates
- Boundary traversal
- Row/column markers

**Core Idea:**

Solve matrix traversal and transformation problems using row/column techniques.

**Common interview tricks:**

- Use transpose and reverse for rotation
- Mark first row/column for constant-space updates
- Use boundary variables for spiral traversal

**Complexity insight:**

O(m*n) for matrix operations.

**Problems in repository:**

- 048 Rotate Image
- 054 Spiral Matrix
- 073 Set Matrix Zeroes
- 1582 Special Positions in a Binary Matrix
