/*
There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.

Could you please decide the first player will win or lose?

Have you met this question in a real interview? Yes
Example
Given array A = [3,2,2], return true.

Given array A = [1,2,4], return true.

Given array A = [1,20,4], return false.

Challenge
Follow Up Question:

If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?
*/

public class Solution {
    public boolean firstWillWin(int[] values) {
        int len = values.length;
        if (len <= 1) {
            return true;
        }
        int[][] store = new int[len][len];
        int[][] sum = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum[i][j] = i == j ? values[j] : sum[i][j-1] + values[j];
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    store[i][j] = values[i];
                } else {
                    int cur = Math.min(store[i+1][j], store[i][j-1]);
                    store[i][j] = sum[i][j] - cur;
                }
            }
        }
        return store[0][len - 1] > sum[0][len-1] - store[0][len - 1];
    }
}

/*
dp题，主要是要推导出公式：
dp[i][j]=max(A[i]+sum[i+1][j]-dp[i+1][j], A[j]+sum[i][j-1]-dp[i][j-1])
A[i]+sum[i+1][j] 和 A[j]+sum[i][j-1]都等于sum[i][j],因此最后公式成为：
dp[i][j]=sum[i][j]-min(dp[i+1][j],dp[i][j-1])
比较特别的dp题。game theory

https://codesolutiony.wordpress.com/2015/05/24/lintcode-coins-in-a-line-iii/
http://blog.csdn.net/wangyuquanliuli/article/details/45922775
https://github.com/kamyu104/LintCode/blob/master/C++/coins-in-a-line-iii.cpp
http://techinpad.blogspot.com/2015/05/lintcode-coins-in-line-iii.html
*/