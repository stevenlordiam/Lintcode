/*
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Have you met this question in a real interview? Yes
Example
Given [1,2,2,1,3,4,3], return 4

Challenge
One-pass, constant extra space.
*/

public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i < A.length; i++) {    // 异或所有数，相同的数抵消
            rst ^= A[i];
        }
        return rst;
    }
}