/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Have you met this question in a real interview? Yes
Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Clarification
Your algorithm should run in O(n) complexity.
*/

public class Solution {
    // Sort & search: space O(1), time O(n logn)
    // HashMap: space O(n), time O(n)
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i: num){
            hs.put(i, 0);   // 把每个元素存在hashmap里面
        }
        int maxl = 1;
        for(int i: num){
            if (hs.get(i) == 1) continue;   // value 1表示已经扫过这个元素

            int tmp = i;
            int current_max = 1;
            while(hs.containsKey(tmp+1)){   // 向后扫，如果数组中存在i+1的元素，则有连续子序列
                current_max ++;
                tmp ++;
                hs.put(tmp, 1);
            }

            tmp = i;
            while(hs.containsKey(tmp-1)){   // 向前扫，如果数组中存在i-1的元素，则有连续子序列
                current_max ++;
                tmp --;
                hs.put(tmp, 1);
            }

            maxl = Math.max(current_max, maxl);
        }

        return maxl;
    }
}