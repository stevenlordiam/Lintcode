/*
Find the Nth number in Fibonacci sequence.

A Fibonacci sequence is defined as follow:

The first two numbers are 0 and 1.
The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

Have you met this question in a real interview? Yes
Example
Given 1, return 0

Given 2, return 1

Given 10, return 34

Note
The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.
*/

public class Solution {
    public int fibonacci(int n) {
        int stepOne = 0;
        int stepTwo = 1;
        if(n==1){
            return 0;
        }
        if(n==2 || n==3){
            return stepTwo;
        }
        for(int i=3;i<=n;i++){
            int stepThree = stepOne+stepTwo;
            stepOne = stepTwo;              // if n-1 step took i ways, then n if stepOne, i+1 way([1]); if stepTwo, i+2 way([1,1] or [2])
            stepTwo = stepThree;
        }
        return stepTwo;
    }
}