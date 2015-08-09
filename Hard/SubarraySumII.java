/*
Given an integer array, find a subarray where the sum of numbers is between two given interval. Your code should return the number of possible answer.

Example
Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:

[0, 0]
[0, 1]
[1, 1]
[2, 2]
*/

public class Solution {
    public int subarraySumII(int[] A, int start, int end) {
        int n = 0;
        int[] B = new int[A.length];
        B[0] = A[0];
        for(int i = 1; i < A.length; i++){
            B[i] = B[i-1]+A[i];
        }
        for(int i = 0; i < B.length; i++){
            if(B[i] >= start && B[i] <= end){
                n++;
                // System.out.println(0 + " " + i);
            }           
            for(int j = 0; j < i; j++){
                if((B[i]-B[j] >= start) && (B[i]-B[j] <= end)){
                    n++;
                    // System.out.println(j+1 + " " + i);
                }               
            }
        }
        return n;
    }
}

/*
https://lintcode.wordpress.com/2015/05/31/subarray-sum-i-ii/
http://www.cnblogs.com/easonliu/p/4543647.html
*/