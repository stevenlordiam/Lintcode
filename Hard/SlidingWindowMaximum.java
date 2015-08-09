/*
Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.

Have you met this question in a real interview? Yes
Example
For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]

At first the window is at the start of the array like this

[|1, 2, 7| ,7, 8] , return the maximum 7;

then the window move one step forward.

[1, |2, 7 ,7|, 8], return the maximum 7;

then the window move one step forward again.

[1, 2, |7, 7, 8|], return the maximum 8;

Challenge
o(n) time and O(k) memory
*/

public class Solution {
    
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int i = 0;

        
        for(int now : nums) {
            i++;
            
    		while((!deque.isEmpty() && now > deque.peekLast())) {
    			deque.pollLast();
    		} 
    		deque.offer(now);
    		if(i > k  && deque.peekFirst() == nums[i - k - 1])
    		         deque.pollFirst();
    		if(i >= k) {
    			ans.add(deque.peekFirst());
    		}
            
        }
        return ans;

    }
}