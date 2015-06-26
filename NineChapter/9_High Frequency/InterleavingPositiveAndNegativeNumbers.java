/*
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.

Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.

Note
You are not necessary to keep the original order of positive integers or negative integers.

Challenge
Do it in-place and without extra memory.
*/

public class Solution {

    public static void rerange(int[] A) {

        if (A == null || A.length <= 2) {
            return;
        }
        
        int len = A.length;    
        int cntPositive = 0;
        int i1 = 0;     // store the positive numbers index
        
        for (int i2 = 0; i2 < len; i2++) {
            if (A[i2] > 0) {
                cntPositive++;
                swap(A, i1++, i2);  // Put all the positive numbers at in the left part
            }
        }
        
        int posPointer = 1; // If positive numbers are more than negative numbers, put the positive numbers at first
        int negPointer = 0;
        
        if (cntPositive > A.length / 2) {   // Have more Positive numbers
            posPointer = 0;
            negPointer = 1;
            int left = 0;
            int right = len -1;
            while (right >= cntPositive) {  // Reverse the array
                swap(A, left, right);
                left++;
                right--;
            }
        }
        
        while (true) {  // Reorder the negative and the positive numbers
            while (posPointer < len && A[posPointer] > 0) {
                posPointer += 2;
            }
            while (negPointer < len && A[negPointer] < 0) {
                negPointer += 2;
            }
            
            if (posPointer >= len || negPointer >= len) {
                break;
            }
            
            swap(A, posPointer, negPointer);
        }
        
        return;
   }
   
   public static void swap(int[] A, int n1, int n2) {
       int tmp = A[n1];
       A[n1] = A[n2];
       A[n2] = tmp;
   }
}

/*
http://www.cnblogs.com/yuzhangcmu/p/4175620.html
http://www.cnblogs.com/EdwardLiu/p/4314781.html
http://blog.csdn.net/nicaishibiantai/article/details/43448341
http://www.shuatiblog.com/blog/2014/10/08/interleave-positive-negative/
*/