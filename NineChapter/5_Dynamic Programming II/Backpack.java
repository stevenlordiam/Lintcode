/*
Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

Have you met this question in a real interview? Yes
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

Note
You can not divide any item into small pieces.

Challenge
O(n x m) time and O(m) memory.

O(n x m) memory is also acceptable if you do not know how to optimize memory.
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];       //  “前i”个数,取出一些能否组成和为j
        for (int i = 0; i <= A.length; i++) {
            f[i][0] = true;
        }
        for (int j = 1; j <= m; j++) {
                f[0][j] = false;
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= A[i] && f[i][j - A[i]]) {      // 保证j-A[i]不是负数
                    f[i + 1][j] = true;
                }
            } 
        } 
        
        for (int i = m; i >= 0; i--) {      // max size
            if (f[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
}