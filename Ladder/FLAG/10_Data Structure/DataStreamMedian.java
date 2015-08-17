/*
Numbers keep coming, return the median of numbers at every time a new number added.

Have you met this question in a real interview? Yes
Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

Challenge
Total run time in O(nlogn).

Clarification
What's the definition of Median? - Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
            // write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10,
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b) {
                        return b - a;
                    }
                });

        int len = nums.length;
        int[] res = new int[len];
        res[0] = nums[0];
        minHeap.add(nums[0]);

        for (int i = 1; i < len; i++) {
            // First compare current number with minHeap
            // then add it two min/maxHeap accordingly.
            // Then banlance two heaps so that they only differ
            // by at most one element.
            // Last compare the size and get the median: if same size
            // then median is average of two roots. Otherwise median
            // is the root of longer heap.

            // push to heaps.
            // minHeap: store the bigger value. root(min) value is the smallest
            // element in right half of the array.
            // maxHeap: store smaller values. root(max) value is the largest element
            // in the left half of the array.

            // [maxHeap->median->minHeap]
            int current = nums[i];
//           {4, 5, 1, 3, 2, 6, 0};
            //  4
            //  5
            if (current < minHeap.peek()) {
                maxHeap.add(current);
            } else {
                minHeap.add(current);
            }

            // balance the heaps.
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }

            int minSize = minHeap.size();
            int maxSize = maxHeap.size();
            if (minSize == maxSize) {
                res[i] = maxHeap.peek();
            } else {
                res[i] = minSize > maxSize? minHeap.peek() : maxHeap.peek();
            }
        }

        return res;
    }
}

/*
http://www.jiuzhang.com/solutions/median-in-data-stream/
http://blog.csdn.net/xudli/article/details/46389077
http://www.cnblogs.com/yuzhangcmu/p/4243174.html
https://github.com/shogunsea/lintcode/blob/master/data-stream-median.java
*/