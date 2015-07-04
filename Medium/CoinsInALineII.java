/*
There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Have you met this question in a real interview? Yes
Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false
*/

public class Solution {
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length <= 2) {
            return true;
        }
        int second = values[values.length - 1];
        int first = values[values.length - 2] + second;
        int sum = first;
 
        for (int i = values.length - 3; i >= 0; i--) {
            sum += values[i];
            int cur = sum - Math.min(second, first);
            second = first;
            first = cur;
        }
        return first > (sum - first);
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/24/lintcode-coins-in-a-line-ii/
http://www.cnblogs.com/easonliu/p/4525201.html
http://techinpad.blogspot.com/2015/05/lintcode-coins-in-line-ii.html
*/