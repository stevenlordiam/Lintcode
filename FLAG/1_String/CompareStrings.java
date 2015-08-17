/*
Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

Have you met this question in a real interview? Yes
Example
For A = "ABCD", B = "ACD", return true.

For A = "ABCD", B = "AABC", return false.

Note
The characters of B in A are not necessary continuous or ordered.
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        int[] AA = new int[26];
        int[] BB = new int[26];
        for (int i=0; i<A.length(); i++) {
            AA[A.charAt(i) - 'A']++;
        }
        for (int i=0; i<B.length(); i++) {
            BB[B.charAt(i) - 'A']++;
            if (BB[B.charAt(i) - 'A'] > AA[B.charAt(i) - 'A']) return false;    // 注意比较的是两个array里B的char
        }
        return true;
    }
}