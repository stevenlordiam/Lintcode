/*
Count how many 1 in binary representation of a 32-bit integer.

Have you met this question in a real interview? Yes
Example
Given 32, return 1

Given 5, return 2

Given 1023, return 9

Challenge
If the integer is n bits with m 1 bits. Can you do it in O(m) time?
*/

public class Solution {
    public int countOnes(int num) {
        int count = 0;
        while(num>0) {
            num &= num - 1;
            count++;
        }
        return count;
    }
}

// 讨论一下-1的情况, 然后m & (m - 1)每次都能消掉一个1 (check the power of 2). 数一下这个操作进行了几次就行