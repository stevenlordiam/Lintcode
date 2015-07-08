/*
Given an integer array, find a continuous rotate subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

Have you met this question in a real interview? Yes
Example
Give [3, 1, -100, -3, 4], return [4,1]
*/

// 可以复制一个array ?
// 最大数组的范围只有两种可能：1. [ i ~ j ]，2. [ i ~ N-1] + [ 0 ~ j ]. 所以，你只要分别找到两种情况的最大者，取这两个最大者中较大的即可
// 1和Continuous Subarray Sum I相同，就不多说了。2等价于找一个范围[j+1 ~i-1]，使得这个范围内的数组和最小。这又等价于将原数组取负号，然后在这个负数组中找最大和的[j+1 ~ i+1]范围即可
public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        if(A.length==0)
            return new ArrayList<Integer>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        ArrayList<Integer> maxIndex=new ArrayList<Integer>();
        ArrayList<Integer> minIndex=new ArrayList<Integer>();
        for(int i=0;i<2;i++){
            maxIndex.add(0);
            minIndex.add(0);
        }
        int[] maxArr=new int[A.length];
        int[] minArr=new int[A.length];
        int[] maxStart=new int[A.length];
        int[] minStart=new int[A.length];
        maxArr[0]=A[0];
        minArr[0]=A[0];
        int sum=A[0];
        for(int i=1;i<A.length;i++){
            sum+=A[i];
            if(maxArr[i-1]>0){
                maxArr[i]=maxArr[i-1]+A[i];
                maxStart[i]=maxStart[i-1];
            }
            else{
                maxArr[i]=A[i];
                maxStart[i]=i;
            }
            if(minArr[i-1]<0){
                minArr[i]=minArr[i-1]+A[i];
                minStart[i]=minStart[i-1];
            }
            else{
                minArr[i]=A[i];
                minStart[i]=i;
            }
            if(maxArr[i]>max){
                max=maxArr[i];
                maxIndex.set(0,maxStart[i]);
                maxIndex.set(1,i);
            }
            if(minArr[i]<min){
                min=minArr[i];
                minIndex.set(0,(i+1)%A.length);
                minIndex.set(1,minStart[i]-1>=0?minStart[i]-1:A.length-1);
            }
        }
        if(max>sum-min||min==sum)
            return maxIndex;
        else
            return minIndex;
    }
}

/*
http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
http://stackoverflow.com/questions/6047590/maximum-contiguous-sum-in-a-circular-buffer
http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
https://algnotes.wordpress.com/2012/09/23/maximum-circular-subarray/
http://www.shuatiblog.com/blog/2014/08/11/max-circular-subarray/
http://www.careercup.com/question?id=14185703
*/