/*
Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

Have you met this question in a real interview? Yes
Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].

Note
There is at least one subarray that it's sum equals to zero.
*/

public class Solution {
/*
我们有一个O(N)的解法。使用Map 来记录index, sum的值。当遇到两个index的sum相同时，表示从index1+1到index2是一个解。
注意：添加一个index = -1作为虚拟节点。这样我们才可以记录index1 = 0的解。
空间复杂度：O(N)
*/
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    // key: sum, value: index
        map.put(0, -1);
        //we know that sub-array (a,b) has zero sum if SUM(0 ... a-1) = SUM(0 ... b)
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
            	// For example: 
                 //        -3  1  2 -3 4
                 // SUM: 0 -3 -2  0 -3 1
                 // then we got the solution is : 0 - 2
                rst.add(map.get(sum) + 1);
                rst.add(i);
                return rst;
            }
            map.put(sum, i);
        }//for
        return rst;
    }
}

/*
http://www.cnblogs.com/yuzhangcmu/p/4174507.html
https://codesolutiony.wordpress.com/2015/04/24/lintcode-subarray-sum/
http://www.cnblogs.com/lishiblog/p/4189339.html
https://github.com/shawnfan/LintCode/blob/master/Java/Subarray%20Sum.java
http://www.cnphp6.com/archives/81748
http://blog.welkinlan.com/2015/05/04/subarray-sum-lintcode-hashmap/
https://codesolutiony.wordpress.com/2015/04/24/lintcode-subarray-sum/
*/