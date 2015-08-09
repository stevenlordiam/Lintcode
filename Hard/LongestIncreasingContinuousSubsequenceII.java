/*
Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).

Have you met this question in a real interview? Yes
Example
Given a matrix:

[
  [1 ,2 ,3 ,4 ,5],
  [16,17,24,23,6],
  [15,18,25,22,7],
  [14,19,20,21,8],
  [13,12,11,10,9]
]
return 25

Challenge
O(nm) time and memory
*/

public class Solution {
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        int res = 0;
        if (A == null || A.length == 0 || A[0].length == 0) {
            return res;
        }
        int[][] store = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (store[i][j] == 0) {
                    res = Math.max(res, dfs(A, store, i, j));
                }
            }
        }
        return res;
    }
    private int dfs(int[][] a, int[][] store, int i, int j) {
        if (store[i][j] != 0) {
            return store[i][j];
        }
        int left = 0, right = 0, up = 0, down = 0;
        if (j + 1 < a[0].length && a[i][j+1] > a[i][j]) {
            right = dfs(a, store, i, j+1);
        }
        if (j > 0 && a[i][j-1] > a[i][j]) {
            left = dfs(a, store, i, j-1);
        }
        if (i + 1 < a.length && a[i+1][j] > a[i][j]) {
            down = dfs(a, store, i+1, j);
        }
        if (i > 0 && a[i-1][j] > a[i][j]) {
            up = dfs(a, store, i-1, j);
        }
        store[i][j] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        return store[i][j];
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/25/lintcode-longest-increasing-continuous-subsequence-ii/
http://www.cnblogs.com/jianxinzhou/p/4530825.html
http://blog.csdn.net/earthma/article/details/46008887
*/