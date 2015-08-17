/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.

Have you met this question in a real interview? Yes
Example
Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.

Given A=[1,2,3] and B=[4,5], the median is 3.

Challenge
The overall run time complexity should be O(log (m+n))
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0 ;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start, int[] B, int B_start, int k){		
		if(A_start >= A.length) 
			return B[B_start + k - 1];
		if(B_start >= B.length)
			return A[A_start + k - 1];

		if (k == 1)
			return Math.min(A[A_start], B[B_start]);
		
		int A_key = A_start + k / 2 - 1 < A.length
		            ? A[A_start + k / 2 - 1]
		            : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length
		            ? B[B_start + k / 2 - 1]
		            : Integer.MAX_VALUE; 
		
		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2); 	
			// 若A[k/2] < B[k/2], 则A的前k/2个数都在合并后的数组的前k个, 则A的前k/2 drop, 从A[k/2+1]开始与B比较
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
}