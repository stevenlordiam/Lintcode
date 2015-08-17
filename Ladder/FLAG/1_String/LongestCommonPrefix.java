/*
Given k strings, find the longest common prefix (LCP).

Have you met this question in a real interview? Yes
Example
For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"

For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
*/

public class Solution {
    
    // 1. Method 1, start from the first one, compare prefix with next string, until end;
    // 2. Method 2, start from the first char, compare it with all string, and then the second char
    // I am using method 1 here
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if( j == 0) {
                return "";
	        }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

}