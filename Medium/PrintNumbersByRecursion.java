/*
Print numbers from 1 to the largest number with N digits by recursion.

Example
Given N = 1, return [1,2,3,4,5,6,7,8,9].

Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].

Note
It's pretty easy to do recursion like:

recursion(i) {
    if i > largest number:
        return
    results.add(i)
    recursion(i + 1)
}
however this cost a lot of recursion memory as the recursion depth maybe very large. Can you do it in another way to recursive with at most N depth?

Challenge
Do it in recursion, not for-loop
*/

public class Solution {
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n >= 0) {
            sub(n, res);
        }
        return res;
    }
    private int sub(int n, List<Integer> res) {
        if (n == 0) {
            return 1;
        }
        int base = sub(n - 1, res);
        int size = res.size();
        for (int i = 1; i <= 9; i++) {
            int curBase = i * base;
            res.add(curBase);
            for (int j = 0; j < size; j++) {
                res.add(curBase + res.get(j));
            }
        }
        return base * 10;
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/21/lintcode-print-numbers-by-recursion/
http://blog.csdn.net/martin_liang/article/details/45789183
*/