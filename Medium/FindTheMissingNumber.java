/*
Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.

Have you met this question in a real interview? Yes
Example
Given N = 3 and the array [0, 1, 3], return 2.

Challenge
Do it in-place with O(1) extra memory and O(n) time
*/

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int extra = -1;
        int missNum = nums.length;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i && nums[i] != -1) {
                if (nums[i] < nums.length) {    // 将每个数字交换到它应该出现的位置上来达到O(N)的复杂度
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                } else {
                    extra = nums[i];
                    nums[i] = -1;
                }
            } else if (nums[i] == i) {
                i++;
            } else {
                missNum = i;
                i++;
            }
        }
        return missNum;
    }
}

/*
https://github.com/kamyu104/LintCode/blob/master/C++/find-the-missing-number.cpp
http://dhytxz.github.io/2015/06/22/find-the-missing-number/
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=136816
*/