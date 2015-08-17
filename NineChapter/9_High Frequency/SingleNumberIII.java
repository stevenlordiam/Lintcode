/*
Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Have you met this question in a real interview? Yes
Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
O(n) time, O(1) extra space.
*/

public class Solution {
	/*
	先将所有的数异或，得到的将是x和y以后之后的值n。 因为这两个数一定是不同的，所以最终异或的值至少有一个位为1
    找到这个数n的为1的某一位（为了方便就取最右边为1的一位， n & ~(n-1))，然后根据该位的值是否为1，将数组中的每一个数，分成两个部分
    这样每个部分，就可以采用Sing number I中的方法得到只出现一次的数
	*/
    public List<Integer> singleNumberIII(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        int n = 0;
        for (int elem : A) {
            n ^= elem;
        }
        n = n & (~(n-1));
        for (int elem : A) {
            if ((elem & n) != 0) {
                res.set(0, res.get(0)^elem);
            }
            else res.set(1, res.get(1)^elem);
        }
        return res;
    }
}

/*
https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
http://www.cnblogs.com/EdwardLiu/p/4391455.html
https://richdalgo.wordpress.com/2015/02/01/lintcode-single-number-iii/
https://github.com/shawnfan/LintCode/blob/master/Java/Single%20Number%20III.java
http://www.wengweitao.com/lintcode-single-number-i-ii-iii-luo-dan-de-shu.html
*/