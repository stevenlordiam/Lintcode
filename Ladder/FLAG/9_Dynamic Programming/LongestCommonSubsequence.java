/*
Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

Have you met this question in a real interview? Yes
Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

For "ABCD" and "EACB", the LCS is "AC", return 2.

Clarification
What's the definition of Longest Common Subsequence?

https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
http://baike.baidu.com/view/2020307.htm
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
	    int m = B.length();
        int f[][] = new int[n + 2][m + 2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                if(A.charAt(i) == B.charAt(j))
                    f[i + 1][j + 1] = f[i][j] + 1;
            }
        }
        return f[n][m];
    }
}