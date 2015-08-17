/*
Given a set of distinct integers, return all possible subsets.

Note
Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.

Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Tags - Recursion

Leetcode - (78) - Subsets
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(S);  
        subsetsHelper(result, list, S, 0);
        return result;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S, int pos) {     // pos - position
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < S.size(); i++) {        // 回溯法：add -> recursion -> remove last element
            list.add(S.get(i));
            subsetsHelper(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
// int[] num  ->  num.length 
// Arraylist<Integer> S  ->  S.size() 
// num[i]  ->  S.get(i)   (array -> ArrayList)
// Array.sort(num)  ->  Collections.sort(S)