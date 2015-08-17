/*
Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

Have you met this question in a real interview? Yes
Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.

Note
You can assume each number in the array is a positive integer and not greater than 100.
*/

public class Solution {
    public static int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }
        
        // D[i][v]: 把index = i的值修改为v，所需要的最小花费
        int[][] D = new int[A.size()][101];
        
        int size = A.size();
        
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= 100; j++) {
                D[i][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    // The first element.
                    D[i][j] = Math.abs(j - A.get(i));
                } else {
                    for (int k = 1; k <= 100; k++) {
                        // 不符合条件 
                        if (Math.abs(j - k) > target) {
                            continue;
                        }
                        
                        int dif = Math.abs(j - A.get(i)) + D[i - 1][k];
                        D[i][j] = Math.min(D[i][j], dif);
                    }
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            ret = Math.min(ret, D[size - 1][i]);
        }
        
        return ret;
    }
}

/*
Reference:
http://www.cnblogs.com/yuzhangcmu/p/4153927.html
https://codesolutiony.wordpress.com/2015/01/29/lintcode-minimum-adjustment-cost/
http://ryanleetcode.blogspot.com/2015/05/minimum-adjustment-cost.html
*/