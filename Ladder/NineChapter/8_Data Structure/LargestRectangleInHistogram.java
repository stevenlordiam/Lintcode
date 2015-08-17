/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

histogram

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

histogram

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Have you met this question in a real interview? Yes
Example
Given height = [2,1,5,6,2,3],
return 10.
*/

public class Solution { // 找左边或者右边第一个比自己小的元素用stack
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];    // 弹出栈
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;    // i是只有一个元素，栈为空的情况
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
}

/*
以高度枚举，找到左，右边第一个比自己小的 - 用stack
*/