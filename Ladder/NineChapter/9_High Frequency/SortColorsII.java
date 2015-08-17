/*
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

Have you met this question in a real interview? Yes
Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

Note
You are not suppose to use the library's sort function for this problem.

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?
*/

public class Solution { 	// Count sort, 扫两遍即可，需要O(k)的空间
    public void sortColors2(int[] colors, int k) {
        int[] count = new int[k];
        for (int color : colors) {  // 统计每个数字出现的次数
            count[color-1]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (count[i]>0) {
                colors[index++] = i+1;
                count[i]--;
            }
        }
    }
}

// 使用快排，时间复杂度是O(nlogn),空间复杂度是O(1)
/**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    /*
    Solution 1: Using the quick sort.
    */ 
    public void sortKColors1(int[] colors, int k) {
        // write your code here
        if (colors == null) {
            return;
        }
        
        quickSort(colors, 0, colors.length - 1);
    }
    
    public void quickSort(int[] colors, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot = colors[right];
        
        int pos = partition(colors, left, right, pivot);
        
        quickSort(colors, left, pos - 1);
        quickSort(colors, pos + 1, right);
    }
    
    public int partition(int[] colors, int left, int right, int pivot) {
        int leftPoint = left - 1;
        int rightPoint = right;
        
        while (true) {
            while (colors[++leftPoint] < pivot);
            
            while (leftPoint < rightPoint && colors[--rightPoint] > pivot);
            
            if (leftPoint >= rightPoint) {
                break;
            }
            
            swap(colors, leftPoint, rightPoint);
        }
        
        swap(colors, leftPoint, right);
        return leftPoint;
    }
    
    public void swap(int[] colors, int left, int right) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }

// inplace，并且O(N)时间复杂度的算法。
// 我们可以使用类似桶排序的思想，对所有的数进行计数。

// Solution 2: inplace, O(n) 
    public void sortKColors(int[] colors, int k) {
        // write your code here
        if (colors == null) {
            return;
        }
        
        int len = colors.length;
        for (int i = 0; i < len; i++) {
            // Means need to deal with A[i]
            while (colors[i] > 0) {
                int num = colors[i];
                if (colors[num - 1] > 0) {    
                    // 1. There is a number in the bucket, 
                    // Store the number in the bucket in position i;
                    colors[i] = colors[num - 1];
                    colors[num - 1] = -1;
                } else if (colors[num - 1] <= 0) {
                    // 2. Bucket is using or the bucket is empty.
                    colors[num - 1]--;
                    // delete the A[i];
                    colors[i] = 0;
                }
            }
        }
        
        int index = len - 1;
        for (int i = k - 1; i >= 0; i--) {
            int cnt = -colors[i];
            
            // Empty number.
            if (cnt == 0) {
                continue;
            }
                                
            while (cnt > 0) {
                colors[index--] = i + 1;
                cnt--;
            }
        }

/*
http://www.cnblogs.com/yuzhangcmu/p/4177326.html
https://codesolutiony.wordpress.com/2015/05/28/lintcode-sort-colors-ii/
*/