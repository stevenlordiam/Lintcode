/*
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Have you met this question in a real interview? Yes
Example
Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge
O(n) time and O(1) extra space
*/

public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        int candidate = 0, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count ++;
            } else {
                if (candidate == nums.get(i)) {
                    count ++;
                } else {
                    count --;
                }
            }
        }
        return candidate;
    }
}