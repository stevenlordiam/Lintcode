/*
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)

Note
The array may contains multiple peeks, find any of them.

Challenge
Time complexity O(logN)
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int low = 1, high = A.length-2; // 1.答案在之间，2.不会出界
        while(low <= high) {
            int mid = (low + high) / 2;
            if(A[mid] < A[mid - 1]) {
                high = mid - 1;
            } else if(A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
               return mid;
            }
        }
        return -1;
    }
}