/*
Partition an integers array into odd number first and even number second.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 3, 4], return [1, 3, 2, 4]

Challenge
Do it in-place
*/

public class Solution {
    public void partitionArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 != 0) {
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/25/lintcode-partition-array-by-odd-and-even/
*/