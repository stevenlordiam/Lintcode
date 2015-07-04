/*
Find K-th largest element in an array.

Have you met this question in a real interview? Yes
Example
In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

Note
You can swap elements in the array

Challenge
O(n) time, O(1) extra memory
*/

public class Solution {
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if (k < 1 || numbers == null) {
            return 0;
        }
        
        return getKth(numbers.size() - k + 1, numbers, 0, numbers.size() - 1);
        // kth largest is the (numbers.size() - k + 1) element in sorted array
    }
    
    public int getKth(int k, ArrayList<Integer> numbers, int start, int end) {
        // Choose the last one as the pivot
        int pivot = numbers.get(end);
        
        int left = start;
        int right = end;
        
        while (true) {
            while (numbers.get(left) < pivot && left < right) {
                left++;    
            }
            
            while (numbers.get(right) >= pivot && right > left) {
                right--;
            }
            
            if (left == right) {
                break;
            }
            
            swap(numbers, left, right);
        }
        
        // left: the first one which is bigger than pivot.
        swap(numbers, left, end);
        
        if (k == left + 1) {
            return pivot;
        // Try to find the element from the left side.
        } else if (k < left + 1) {
            return getKth(k, numbers, start, left - 1);
        } else {
        // Try to find the element from the right side.            
            return getKth(k, numbers, left + 1, end);
        }
    }
    
    public void swap(ArrayList<Integer> numbers, int n1, int n2) {
        int tmp = numbers.get(n1);
        numbers.set(n1, numbers.get(n2));
        numbers.set(n2, tmp);
    }
}

/*
http://www.cnblogs.com/yuzhangcmu/p/4164807.html
http://www.cnblogs.com/EdwardLiu/p/4322657.html
http://blog.csdn.net/nicaishibiantai/article/details/43305489
*/