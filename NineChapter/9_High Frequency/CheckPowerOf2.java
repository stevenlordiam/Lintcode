/*
Using O(1) time to check whether an integer n is a power of 2.

Have you met this question in a real interview? Yes
Example
For n=4, return true;

For n=5, return false;

Challenge
O(1) time
*/

public class Solution {
    public boolean checkPowerOf2(int n) {
        if (n < 1) {
            return false;
        } else {
            return (n & (n - 1)) == 0;
            // 10000000 & 01111111 == 0 
        }
    }
}

/*
(x-1) & x == 0 → x是2的某次幂
http://algorithm.yuanbin.me/math_and_bit_manipulation/o1_check_power_of_2.html
*/