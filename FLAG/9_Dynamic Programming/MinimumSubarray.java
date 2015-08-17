/*
Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

Have you met this question in a real interview? Yes
Example
For [1, -1, -2, 1], return -3

Note
The subarray should contain at least one integer.
*/

public class Solution {     // 把所有数取反就变成了maximum subarray
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        int len = nums.size();
        if (len==0) return 0;

        int curMin = nums.get(0);
        int minRes = nums.get(0);

        for (int i=1;i<len;i++){
            curMin = Math.min(nums.get(i),curMin+nums.get(i));
            minRes = Math.min(curMin,minRes);
        }
        return minRes;
    }
}

/*
http://www.cnblogs.com/lishiblog/p/4196837.html
http://blog.xiaohuahua.org/2015/01/26/lintcode-minimum-subarray/
http://www.shuatiblog.com/blog/2014/06/28/Minimum-subarray/
http://hehejun.blogspot.com/2015/01/lintcodeminimum-subarray.html
*/