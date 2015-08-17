/*
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
For example, given s = "aab",

Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private boolean[][] getIsPalindrome(String s) {         // 预处理, 用O(N^2)空间存储是不是回文串, 节省时间从O(N^3)到O(N^2)
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] cut = new int[s.length() + 1];    // 前i个字符组成的子字符串需要最少几次cut(最少能被分割为多少个字符串-1)
        boolean[][] isPalindrome = getIsPalindrome(s);

        cut[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            cut[i] = Integer.MAX_VALUE; // 所有一开始都初始成无穷大
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[i - j][i - 1] && cut[i - j] != Integer.MAX_VALUE) {
                    cut[i] = Math.min(cut[i], cut[i - j] + 1);
                }
            }
        }

        return cut[s.length()] - 1;
    }
}