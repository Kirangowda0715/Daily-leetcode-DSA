
/*
- LeetCode 1582 - Special Positions in a Binary Matrix
-
- Pattern:
- Matrix
-
- Approach:
- Count ones per row and column, then identify special positions with exactly one 1 in their row and column.
-
- Time Complexity: O(m*n)
- Space Complexity: O(m+n)
*/

/*
Problem: Special Positions in a Binary Matrix
Approach: Row Count + Column Count

Time Complexity: O(m * n)
Space Complexity: O(m + n)
*/

class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {

        int rows = mat.size();
        int cols = mat[0].size();

        vector<int> rowCount(rows,0);
        vector<int> colCount(cols,0);

        // count number of 1s
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;

        // check special positions
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==1 && rowCount[i]==1 && colCount[j]==1){
                    count++;
                }
            }
        }

        return count;
    }
};