/*
Write an algorithm which computes the number of trailing zeros in n factorial.

Have you met this question in a real interview? Yes
Example
11! = 39916800, so the out should be 2

Challenge
O(log N) time
*/

public class Solution {
    public long trailingZeros(long n) {
        long sum=0;
        long i=n/5;
        while(i>0){
            sum=sum+i;
            i=i/5;
        }
        return sum;
    }
}

/*
10 is the product of 2 and 5. In n!, we need to know how many 2 and 5, and the number of zeros is the minimum of the number of 2 and the number of 5.
Since multiple of 2 is more than multiple of 5, the number of zeros is dominant by the number of 5. 
Sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors. 
*/