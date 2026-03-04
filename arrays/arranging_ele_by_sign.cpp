/*
Problem: 2149. Rearrange Array Elements by Sign

Approach:
We maintain two pointers:
1. posIndex → position where the next positive number should go
2. negIndex → position where the next negative number should go

Since the result must start with a positive number:
positive numbers go at indices: 0, 2, 4, ...
negative numbers go at indices: 1, 3, 5, ...

We traverse the original array once and place elements
directly in their correct positions.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {

        int n = nums.size();

        // posIndex tracks positions for positive numbers (0,2,4,...)
        int posIndex = 0;

        // negIndex tracks positions for negative numbers (1,3,5,...)
        int negIndex = 1;

        // result array
        vector<int> ans(n);

        for(int i = 0; i < n; i++){

            // if number is negative → place at next odd index
            if(nums[i] < 0){
                ans[negIndex] = nums[i];
                negIndex += 2;  // move to next odd index
            }

            // if number is positive → place at next even index
            else{
                ans[posIndex] = nums[i];
                posIndex += 2;  // move to next even index
            }
        }

        return ans;
    }
};