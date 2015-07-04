/*
Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

Have you met this question in a real interview? Yes
Example
Give [-3, 1, 3, -3, 4], return [1,4]
*/

public class Solution {
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return res;
        }
        int sum = A[0];
        int max = sum;
        int start = 0, end = 0;
        res.add(0);
        res.add(0);
        for (int i = 1; i < A.length; i++) {
            if (sum > max) {
                res.set(0, start);  // update the element in the index
                res.set(1, i-1);
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
                start = i;
                end = i;
            }
            sum += A[i];
        }
        if (sum > max) {
            res.set(0, start);
            res.set(1, A.length-1);
        }
        return res;
    }
}

/*
https://codesolutiony.wordpress.com/2015/06/02/lintcode-continuous-subarray-sum/
http://blog.csdn.net/martin_liang/article/details/46640545
http://techinpad.blogspot.com/2015/06/lintcode-continuous-subarray-sum.html
*/