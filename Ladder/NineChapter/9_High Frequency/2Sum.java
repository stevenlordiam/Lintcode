/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

Have you met this question in a real interview? Yes
Example
numbers=[2, 7, 11, 15], target=9

return [1, 2]

Note
You may assume that each input would have exactly one solution

Challenge
Either of the following solutions are acceptable:

O(1) Space, O(nlogn) Time
O(n) Space, O(n) Time
*/

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
	    if(numbers == null || numbers.length < 2) { 	//checking for null and one-element array
	    	return null;
	    }               
	    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
	    for(int i=0; i<numbers.length; i++){
	        hashmap.put(numbers[i], i+1); 	// key: number, value: index
	    }       
	        
	    int[] index = new int[2];
	        
	    for(int i=0; i<numbers.length ; i++){
	        if ( hashmap.containsKey( target - numbers[i] )){
	            int index1 = i+1;
	            int index2 = hashmap.get(target - numbers[i]);
	            if (index1 == index2){
	                continue;
	            }
	            index[0] = index1;
	            index[1] = index2;
	            return index;
	        }
	    }
	    return index;
	}
}