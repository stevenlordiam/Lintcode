/*
Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 1, 2, 1, 3, 3], return 1.

Note
There is only one majority number in the array.

Challenge
O(n) time and O(1) extra space.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1, count2;
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {     // 三个数不同就抵消
            // 统计出现最多的两个数
            if (candidate1 == nums.get(i)) {
                count1 ++;
            } else if (candidate2 == nums.get(i)) {
                count2 ++;
            } else if (count1 == 0) {
                candidate1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        } 
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            // 因为之前统计的是抵消后的count，应该再扫一次看哪个出现的次数多，再扫一次不会增加时间复杂度
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            }
        }    
        return count1 > count2 ? candidate1 : candidate2;
    }
}