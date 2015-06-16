/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3]
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
     
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null)
            return 0;
        int cur = 0;
        int i ,j;
        for(i = 0; i < nums.length;){   // no i++, get i=j in line 31
            int now = nums[i];
            for( j = i; j < nums.length; j++){
                if(nums[j] != now)
                    break;
                if(j-i < 2)
                    nums[cur++] = now;
            }
            i = j;
        }
        return cur;
    }
}