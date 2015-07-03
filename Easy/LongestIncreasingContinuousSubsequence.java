/*
Give you an integer array (index from 0 to n-1, where n is the size of this array)，find the longest increasing continuous subsequence in this array. (The definition of the longest increasing continuous subsequence here can be from right to left or from left to right)

Have you met this question in a real interview? Yes
Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

Note
O(n) time and O(1) extra space
*/

public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }
        boolean fromLeft = true;
        int start = 0;
        res = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                if (fromLeft == true) {
                    res = Math.max(res, i - start + 1);
                } else {
                    start = i - 1;
                    fromLeft = true;
                }
            } else if (A[i] < A[i - 1]) {
                if (fromLeft == false) {
                    res = Math.max(res, i - start + 1);
                } else {
                    start = i - 1;
                    fromLeft = false;
                }
            }
        }
        return res;
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/25/lintcode-longest-increasing-continuous-subsequence/
http://www.cnblogs.com/jianxinzhou/p/4530257.html
*/