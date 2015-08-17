/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

    * Integers in each row are sorted from left to right.

    * Integers in each column are sorted from up to bottom.

    * No duplicate integers in each row or column.

Have you met this question in a real interview? Yes
Example
Consider the following matrix:

[

    [1, 3, 5, 7],

    [2, 4, 7, 8],

    [3, 5, 9, 10]

]

Given target = 3, return 2.

Challenge
O(m+n) time and O(1) extra space
*/

public class Solution {     // 每次去掉一行或者一列，O(m+n)
    public int searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;  // row
        if (m == 0) return 0;
        int n = matrix[0].length;   // column
        if  (n==0) return 0;
        int count = 0;
        
        int i = 0, j = n-1;
        while(i < m && j >= 0) {    // 从右上角往左下角走
            if (matrix[i][j] == target) {
                count++;
                i++;j--;
            }
            else if (matrix[i][j] > target)
               j--;
            else 
               i++;
        }
        
        return count;
    }
}

/*
https://gist.github.com/Sin27/980a201db5d6c2a5729d
http://algorithm.yuanbin.me/binary_search/search_a_2d_matrix_ii.html
http://codeanytime.blogspot.com/2014/12/search-2d-matrix-ii.html
*/