/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

Example
Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

Challenge
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n)
*/

public class Solution { 
	// two pointers.当当前sum已经满足条件后，将start往后移至不满足条件的index为止，再更新结果。复杂度O(n)
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = -1;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum >= s) {
                if (start == end) {
                    res = 1;
                    break;
                }
                while (start < end && sum - nums[start] >= s) {
                    sum -= nums[start];
                    start++;
                }
                res = res == -1 ? end - start + 1 : Math.min(res, end - start + 1);
            }
        }
        return res == -1 ? -1 : res;
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/17/leetcode-minimum-size-subarray-sum/
http://blog.csdn.net/nicaishibiantai/article/details/45814397
http://techinpad.blogspot.com/2015/05/leetcode-minimum-size-subarray-sum.html
http://yuanhsh.iteye.com/blog/2216862
*/