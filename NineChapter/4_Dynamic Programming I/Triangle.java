/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Have you met this question in a real interview? Yes
Example
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle
*/

public class Solution {     // Bottom-Up
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            sum[n - 1][i] = triangle.get(n - 1).get(i);     // 初始化，最后一行元素
        }

        for (int i = n - 2; i >= 0; i--) {  // 自底向上
            for (int j = 0; j <= i; j++) {
                sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return sum[0][0];
    }
}

/*
1) Go from bottom to top
2) We start form the row above the bottom row [size()-2]
3) Each number add the smaller number of two numbers that below it
4) And finally we get to the top we the smallest sum
*/