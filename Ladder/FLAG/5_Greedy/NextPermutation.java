/*
Given a list of integers, which denote a permutation.

Find the next permutation in ascending order.

Have you met this question in a real interview? Yes
Example
For [1,3,2,3], the next permutation is [1,3,3,2]

For [4,3,2,1], the next permutation is [1,2,3,4]

Note
The list may contains duplicate integers
*/

public class Solution {
    public int[] nextPermutation(int[] num) {
        if (num == null) {
            return null;
        }
        
        int len = num.length;
        for (int i = len - 2; i >= 0; i--) {
            if (num[i + 1] > num[i]) {
                int j;
                for (j = len - 1; j > i - 1; j--) {
                    if (num[j] > num[i]) {
                        break;
                    }
                }

                swap(num, i, j);
                reverse(num, i + 1, len-1);
                return num;
            }
        }

        reverse(num, 0, len-1);
        return num;
    }

    void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    void reverse(int[] num, int beg, int end) {
        for (int i = beg, j = end; i < j; i ++, j --) {
            swap(num, i, j);
        }
    }
}

// version 2
public class Solution {
    /**
     * @param num: an array of integers
     * @return: return nothing (void), do not return anything, modify num in-place instead
     */
     
    public void reverse(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }
    
    public void nextPermutation(int[] num) {
        // find the last increase index
        int index = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(num, 0, num.length - 1);
            return;
        }
        
        // find the first bigger one
        int biggerIndex = index + 1;
        for (int i = num.length - 1; i > index; i--) {
            if (num[i] > num[index]) {
                biggerIndex = i;
                break;
            }
        }
        
        // swap them to make the permutation bigger
        int temp = num[index];
        num[index] = num[biggerIndex];
        num[biggerIndex] = temp;
        
        // reverse the last part
        reverse(num, index + 1, num.length - 1);
    }
}