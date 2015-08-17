/*
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Have you met this question in a real interview? Yes
Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

Challenge
If the count of numbers is bigger than 2^32, can your code work properly?
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int mid; 
        
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                end = mid;
                // cannot return mid here, must set end = mid, or cannot pass the test case [3,4,5,8,8,8,8,10,13,14], 8
            } else if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target){
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}