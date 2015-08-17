/*
Calculate the a^n % b where a, b and n are all 32bit integers.

Have you met this question in a real interview? Yes
Example
For 2^31 % 3 = 2

For 100^1000 % 1000 = 0

Challenge
O(logn)
*/

public class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }
        
        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;          // x^n = (x^(n/2))^2 快速幂 -> O(logn)
        if (n % 2 == 1) {   // if n is odd number, then in recursion n/2 one "a" is omitted, so need to add one more "a" here
            product = (product * a) % b;
        }
        return (int) product;
    }
}

/*
http://www.cnblogs.com/yuzhangcmu/p/4174781.html

实际上这题应该是suppose n > 0的
我们利用 取模运算的乘法法则： http://baike.baidu.com/view/4887065.htm
(a * b) % p = (a % p * b % p) % p 
将 a^n % b 分解为 (a^(n/2) * a^(n/2) * (a)) %b = ((a^(n/2) * a^(n/2))%b * (a)%b) %b = ((a^(n/2)%b * a^(n/2)%b)%b * (a)%b) %b

注意2个base case: n = 0 n = 1都要特别处理。因为n = 1时，会分解出一个pow(a, b, 1)，这个会不断循环调用
*/