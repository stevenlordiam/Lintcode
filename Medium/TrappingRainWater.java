/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Trapping Rain Water

Have you met this question in a real interview? Yes
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge
O(n) time and O(1) memory

O(n) time and O(n) memory is also acceptable
*/

public class Solution {
    public int trap(int[] A) {
        int sum = 0;
        int max = -1;
        int maxIndex = -1;
        int prev;

        // find the highest bar
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                maxIndex = i;
            }
        }

        // process all bars left to the highest bar
        prev = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (A[i] > prev) {
                sum += (A[i] - prev) * (maxIndex - i);
                prev = A[i];
            }
            sum -= A[i];
        }

        // process all bars right to the highest bar
        prev = 0;
        for (int i = A.length - 1; i > maxIndex; i--) {
            if (A[i] > prev) {
                sum += (A[i] - prev) * (i - maxIndex);
                prev = A[i];
            }
            sum -= A[i];
        }

        return sum;
    }
}

version 2:
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        
        int[] maxHeights = new int[heights.length + 1];
        maxHeights[0] = 0;
        for (int i = 0; i < heights.length; i++) {
            maxHeights[i + 1] = Math.max(maxHeights[i], heights[i]);
        }
        
        int max = 0, area = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            area += Math.min(max, maxHeights[i]) > heights[i]
                    ? Math.min(max, maxHeights[i]) - heights[i]
                    : 0;
            max = Math.max(max, heights[i]);
        }
        
        return area;
    }
}

/*
http://www.jiuzhang.com/solutions/count-of-smaller-number/
https://codesolutiony.wordpress.com/2015/05/21/lintcode-count-of-smaller-number/
*/