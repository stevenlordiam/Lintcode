/*
Given a list of numbers, return all possible permutations.

Example
For nums [1,2,3], the permutaions are: 

[
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
]

Challenge
Do it without recursion

Tags - Recursion

Leetcode - (46) Permutations
*/


class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
         ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
         if (nums == null || nums.size() == 0) {
             return rst; 
         }

         ArrayList<Integer> list = new ArrayList<Integer>();
         helper(rst, list, nums);
         return rst;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, ArrayList<Integer> nums){
        // 是permutation而不是subset, 所以不用pos
        if(list.size() == nums.size()) {        // 保证长度一致 -> 保证是permutation而不是子集
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i<nums.size(); i++){      // backtracking
            if(list.contains(nums.get(i))){
                continue;		// 跳过当前循环，进入下一个循环(i+1)
            }
            list.add(nums.get(i));
            helper(rst, list, nums);
            list.remove(list.size() - 1);   // 递归之后要移除 (???)
        }   // 回溯法这种题目都是使用这个套路，就是用一个循环去枚举当前所有情况，然后把元素加入，递归，再把元素移除
            // http://blog.csdn.net/u010500263/article/details/18178243
    }
    
}