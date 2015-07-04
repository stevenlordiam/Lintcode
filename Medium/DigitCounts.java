/*
Count the number of k's between 0 and n. k can be 0 - 9.

Have you met this question in a real interview? Yes
Example
if n=12, k=1 in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)
*/

public class Solution {
    public int digitCounts(int k, int n) {
        // write your code here
        int result = 0;
        int base = 1;
        while (n/base > 0) {
            int cur = (n/base)%10;
            int low = n - (n/base) * base;;
            int high = n/(base * 10);

            if (cur == k) {
                result += high * base + low + 1;
            } else if (cur < k) {
                result += high * base;
            } else {
                result += (high + 1) * base;
            }
            base *= 10;
        }
        return result;
    }
}

/*
http://blog.csdn.net/nicaishibiantai/article/details/43369937
http://www.jiuzhang.com/problem/52/
http://www.cnblogs.com/lishiblog/p/4194962.html
https://github.com/shogunsea/lintcode/blob/master/digit-counts.java
http://blog.xiaohuahua.org/2015/01/25/lintcode-digit-counts/
http://www.myext.cn/c/a_7543.html
*/