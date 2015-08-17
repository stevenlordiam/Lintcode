/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Have you met this question in a real interview? Yes
Example
Given [1, 0, 1, 2], return [0, 1, 1, 2].

Note
You are not suppose to use the library's sort function for this problem.

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

public class Solution {
    public void sortColors(int[] a) {
        if(a == null || a.length <= 1)
            return;
        
        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while(i <= pr){
            if(a[i] == 0){
                swap(a, pl, i);     // element swap to left, i move to next
                pl++;
                i++;
            }else if(a[i] == 1){    // element stays in place, i move to next
                i++;
            }else{
                swap(a, pr, i);     // element swap to right, i move to next
                pr--;
            }
        }
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}