/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Have you met this question in a real interview? Yes
Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3
*/

public class Solution {
    public int climbStairs(int n) {
        int stepOne = 1;
        int stepTwo = 2;
        if(n<=1){
            return n;
        }
        if(n==2){
            return stepTwo;
        }
        for(int i=3;i<=n;i++){
            int stepThree = stepOne+stepTwo;    // f[i] = f[i-1] + f[i-2]
            stepOne = stepTwo;                  // if n-1 step took i ways, then n if stepOne, i+1 way([1]); if stepTwo, i+2 way([1,1] or [2])
            stepTwo = stepThree;
        }
        return stepTwo;     // f[n]
    }
}