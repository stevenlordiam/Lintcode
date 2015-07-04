/*
Given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e g , M becomes a substring of N located at i and starting at j)

Have you met this question in a real interview? Yes
Example
Given N=(10000000000)2, M=(10101)2, i=2, j=6

return N=(10001010100)2

Note
In the function, the numbers N and M will given in decimal, you should also return a decimal number.

Challenge
Minimum number of operations?

Clarification
You can assume that the bits j through i have enough space to fit all of M. That is, if M=10011， you can assume that there are at least 5 bits between j and i. You would not, for example, have j=3 and i=2, because M could not fully fit between bit 3 and bit 2
*/

public class Solution {
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask;
        if (j < 31) {
            mask = ~((1 << (j + 1)) - (1 << i));
        } else {
            mask = (1 << i) - 1;
        }
        return (m << i) + (mask & n);
    }
}

// CC150 5.1
public class Solution {
    public int updateBits(int n, int m, int i, int j){
        // create a mask to clear bits i through j in n
        // EXAMPLE: i=2, j=4. Result should be 11100011
        int allOnes = ~0;   // will equal sequence of all 1s (not just 1, it's 11111111 !!!)
        
        // 1s before position j, then 0s. left = 11100000
        int left = allOnes<<(j+1);  // remember to PLUS ONE     
        int right = ((1<<i)-1);     // 1's after position i. right = 00000011

        int mask = left|right;      // all 1s, except for 0s between i and j. mask = 11100011

        int n_cleared = n&mask;     // clear bits j through i
        int m_shifted = m<<i;       // move M into correct position

        return n_cleared|m_shifted; // OR them
    }
}