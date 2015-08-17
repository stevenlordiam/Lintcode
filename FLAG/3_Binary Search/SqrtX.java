/*
Implement int sqrt(int x).

Compute and return the square root of x.

Have you met this question in a real interview? Yes
Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge
O(log(x))
*/

public class Solution {     // Bisection Method
    public int sqrt(int x) {
        long lo = 0;
        long hi = x;

        while (hi >= lo) {     
            long mid = lo+(hi-lo)/2;    // mark as long in case that mid*mid overflow
            if (x < mid * mid) {
                hi = mid-1;      // not hi = mid
            } else {
                lo = mid+1;  
            }
        }
        return (int) hi;
    }
}