/*
Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining digits are arranged according to the original order to become a new positive integer.

Find the smallest integer after remove k digits.

N <= 240 and k <= N,

Have you met this question in a real interview? Yes
Example
Given an integer A = "178542", k = 4

return a string "12"
*/

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    private String remove(String A, int pos) {
        return A.substring(0, pos) + A.substring(pos + 1, A.length());
    }
    
    public String DeleteDigits(String A, int k) {
        if (A.length() == k) {
            return "";
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < A.length(); j++) {
                if (j == A.length() - 1 || A.charAt(j + 1) < A.charAt(j)) {
                    A = remove(A, j);
                    break;
                }
            }
        }
        
        int i = 0;
        while (i < A.length() - 1 && A.charAt(i) == '0') {  // delete the starting zero
            i++;
        }
        return A.substring(i, A.length());
    }
}

/*
http://www.cnblogs.com/EdwardLiu/p/4276260.html
http://blog.welkinlan.com/2015/05/29/delete-digits-lintcode-java/
https://codesolutiony.wordpress.com/2015/03/27/lintcode-delete-digits/
*/