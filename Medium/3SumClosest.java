/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

Have you met this question in a real interview? Yes
Example
For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Note
You may assume that each input would have exactly one solution.

Challenge
O(n^2) time, O(1) extra space
*/

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (num == null || num.length < 3) {
			return Integer.MAX_VALUE;
		}
		Arrays.sort(num);
		int closet = Integer.MAX_VALUE / 2; // otherwise it will overflow for opeartion (closet-target)'
		for (int i = 0; i < num.length - 2; i++) {
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
				closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum : closet;
			}
		}
		return closet;
	}
}