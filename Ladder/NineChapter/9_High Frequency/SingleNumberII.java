/*
Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Have you met this question in a real interview? Yes
Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge
One-pass, constant extra space.
*/

public class Solution {
    public int singleNumberII(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;   // A[j]的第i位是0还是1
                bits[i] %= 3;       // 不进位加法， XOR3
            }

            result |= (bits[i] << i);
        }
        return result;
    }
}

/*
http://www.wengweitao.com/lintcode-single-number-i-ii-iii-luo-dan-de-shu.html
*/