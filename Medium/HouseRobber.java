/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Have you met this question in a real interview? Yes
Example
Given [3, 8, 4], return 8.

Challenge
O(n) time and O(1) memory
*/

public class Solution {
    public long houseRobber(int[] A) {
        // f[i] = max(f[i - 2] + nums[i], f[i - 1])
        long be4_yesterday = 0, yesterday = 0, today = 0;
        for (int i = 0; i < A.length; i++) {
            today = Math.max(be4_yesterday + A[i], yesterday);
            be4_yesterday = yesterday;
            yesterday = today;
        }
        return today;
    }
}