/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination. // 同一个元素只能用一次

Note
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example
For example, given candidate set 10,1,6,7,2,1,5 and target 8,

A solution set is: 
[1,7]
[1,2,5]
[2,6]
[1,1,6]
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length==0)
            return res;
        Arrays.sort(num);	// no dup -> sort first!!!
        helper(num,0,target,new ArrayList<Integer>(),res);
        return res;
    }

    private void helper(int[] num, int start, int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if(target<0 || start>=num.length)
            return;
        for(int i=start;i<num.length;i++){
            if(i>start && num[i]==num[i-1]) continue;
            item.add(num[i]);                           
            helper(num,i+1,target-num[i],item,res); 	// I同一元素可用多次所以是从i开始，II同一元素只能用一次所以应该从i+1开始，只有这里不一样
            item.remove(item.size()-1);					// 递归的时候传进去的index应该是当前元素的下一个(以避免重复元素)
        }
    }
}