/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Have you met this question in a real interview? Yes
Example
Challenge
O(n^3) time
*/

public class Solution {
    /*
       Second method: comes up with DP naturally
       f[n][i][j] means isScramble(s1[i: i+n], s2[j: j+n])
       f[n][i][j] = f[k][i][j] && f[n - k][i+k][j+k]
                   || f[k][i][j+n-k] && f[n-k][i+k][j]
  
   */
    
     public boolean isScramble(String s1, String s2) {
        if( s1.length() != s2.length() ){
            return false;
        }
        
        if( s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        
        int n = s1.length();
        boolean[][][] rst = new boolean[n][n][n];
        for(int i=0; i< n; i++){
            for(int j=0;j<n; j++){
                rst[0][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        
        for(int len = 2; len <= n; len++){
            for(int i = n - len; i>= 0; i--) {
                for(int j = n - len;  j>=0; j--){
                    boolean r = false;
                    for(int k = 1; k < len && r == false; k++){
                        r = (rst[k-1][i][j] && rst[len-k-1][i+k][j+k]) || (rst[k-1][i][j+len-k] && rst[len-k-1][i+k][j]);
                    }
                    rst[len-1][i][j] = r;
                }
            }
        }
        
        return rst[n-1][0][0];
     }
    
    
    
    
/*
// Recursion method, exponential but trim lots of unnecessary recursion

   public boolean isScramble(String s1, String s2) {
       if( s1.length() != s2.length() ){
           return false;
       }
      
       if( s1.length() == 0 || s1.equals(s2)) {
           return true;
       }
      
       if(! sorted_sequence(s1).equals(sorted_sequence(s2)))  // this could trim lots of uncessary recursion
           return false;
      
       for(int i = 1; i <= s1.length() - 1; i++) {
           String s11 = s1.substring(0, i);
           String s12 = s1.substring(i);
           String s21 = s2.substring(0, i);
           String s22 = s2.substring(i);
           String s31 = s2.substring(0, s2.length()-i);
           String s32 = s2.substring(s2.length() - i);

           if( (isScramble(s11, s21) && isScramble(s12, s22)) ||
               (isScramble(s11, s32) && isScramble(s12, s31)) ) {
               return true;
           }
       }
       return false;
   }
  
   private String sorted_sequence(String s){
       char[] arr = s.toCharArray();
       Arrays.sort(arr);
       return new String(arr);
   }
  
*/
}