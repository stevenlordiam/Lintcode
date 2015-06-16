/*
Given a list of numbers with duplicate number in it. Find all unique permutations.

Example
For numbers [1,2,2] the unique permutations are:

[
    [1,2,2],

    [2,1,2],

    [2,2,1]
]

Challenge
Do it without recursion.

Tags - Recursion

Leetcode - (47) Permutations II
*/


class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */

    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums==null && nums.size()==0)
            return res;

        Collections.sort(nums);		// sort first to avoid dups
        helper(nums, new boolean[nums.size()], new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(ArrayList<Integer> nums, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        if(item.size() == nums.size()){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=0;i<nums.size();i++){
            if(i>0 && !used[i-1] && nums.get(i)==nums.get(i-1)) continue;		// 跳过重复元素(???) 保证不会出现重复解（比如[112],[112] -> 第一个1分别出现在第一位和第二位形成的重复解）
            if(!used[i]){
                used[i] = true;
                item.add(nums.get(i));
                helper(nums, used, item, res);      // 长度相同所以不是i+1
                item.remove(item.size()-1);			// backtracking, remove last element
                used[i] = false;       // 记得标记成false表示现在不在使用这个元素
            }
        }
    }
}