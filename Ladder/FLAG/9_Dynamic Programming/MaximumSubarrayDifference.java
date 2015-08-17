/*
Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

Have you met this question in a real interview? Yes
Example
For [1, 2, -3, 1], return 6

Note
The subarray should contain at least one number

Challenge
O(n) time and O(n) space.
*/

public class Solution {
    // 思路：把数组分成两部分，可以从i和i+1(0<=  i < len-1)之间分开，a[0, i] a[i+1, len-1]
    // 然后分别求两个子数组中的最大子段和，以及最小字段和，然后求差的最大值即可
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int[] maxFromLeft = new int[nums.size()];
        int[] minFromLeft = new int[nums.size()];
        int min = nums.get(0);
        int max = min;
        int localmin = min;
        int localmax = max;
        maxFromLeft[0] = minFromLeft[0] = min;
        for (int i = 1; i < nums.size(); i++) {
            localmin = Math.min(nums.get(i), localmin+nums.get(i));
            localmax = Math.max(nums.get(i), localmax+nums.get(i));
            max = Math.max(max, localmax);
            min = Math.min(min, localmin);
            maxFromLeft[i] = max;
            minFromLeft[i] = min;
        }
        min = nums.get(nums.size() - 1);
        max = min;
        localmin = min;
        localmax = max;
        int res = Math.max(max - minFromLeft[nums.size()-2],
                           maxFromLeft[nums.size() - 2] - min);
        for (int i = nums.size() - 2; i > 0; i--) {
            localmin = Math.min(nums.get(i), localmin+nums.get(i));
            localmax = Math.max(nums.get(i), localmax+nums.get(i));
            max = Math.max(max, localmax);
            min = Math.min(min, localmin);
            res = Math.max(res, Math.max(max - minFromLeft[i-1],
                           maxFromLeft[i-1] - min));
        }
        return res;
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/28/lintcode-maximum-subarray-difference/
http://www.cnblogs.com/EdwardLiu/p/4336961.html
http://www.cnblogs.com/lishiblog/p/4187963.html
http://hehejun.blogspot.com/2015/01/lintcodemaximum-subarray-difference.html
http://blog.csdn.net/nicaishibiantai/article/details/44490241
*/