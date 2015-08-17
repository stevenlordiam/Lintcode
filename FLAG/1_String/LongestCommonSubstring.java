/*
Given two strings, find the longest common substring.

Return the length of it.

Have you met this question in a real interview? Yes
Example
Given A = "ABCD", B = "CBCE", return 2.

Note
The characters in substring should occur continuously in original string. This is different with subsequence.

Challenge
O(n x m) time and memory.
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int maxlen = 0;
        int xlen = A.length();
        int ylen = B.length();
        for(int i = 0; i < xlen; ++i) {
		    for(int j = 0; j < ylen; ++j) {
			    int len = 0;
                while (i + len < xlen && j + len < ylen && A.charAt(i + len) == B.charAt(j + len))
                        len ++;
			    if(len > maxlen)
				    maxlen = len;
		    }
	    }
        return maxlen;
    }
}