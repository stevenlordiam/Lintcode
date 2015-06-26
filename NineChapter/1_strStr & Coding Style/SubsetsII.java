/*
Given a list of numbers that may has duplicate numbers, return all possible subsets

Note
Each element in a subset must be in non-descending order.

The ordering between two subsets is free.

The solution set must not contain duplicate subsets.

Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Tags - Recursion
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(S == null || S.size() ==0) {
            return result;
        }
        Collections.sort(S);
        subsetsHelper(result, list, S, 0);
        return result;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < S.size(); i++) {

            if ( i != pos && S.get(i) == S.get(i-1)) {    // the only difference with subsets is that here you have to check for dups
                continue;                 // 记得要 i!=pos 不能跳过当前数取下一个一样的数字（只能取第一个数不能取之后重复的数）
            }    
            
            list.add(S.get(i));
            subsetsHelper(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
       
}



/*
Leetcode - (90) Subsets II


*/