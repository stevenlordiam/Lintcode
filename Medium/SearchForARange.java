/*
Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].

Have you met this question in a real interview? Yes
Example
Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].

Challenge
O(log n) time.
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        int start, mid, end;
        ArrayList<Integer> range = new ArrayList<Integer>();
        if(A.size() == 0) {
            range.add(0, -1);
            range.add(1, -1);
            return range;
        }
        
        
        start = 0;
        end = A.size() - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A.get(start) == target) {
            range.add(0, start);
        } else if (A.get(end) == target) {
            range.add(0, end);
        } else {
            range.add(0, -1);
            range.add(1, -1);
            return range;
        }
        
        start = 0;
        end = A.size() - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                start = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A.get(end) == target) {
            range.add(1, end);
        } else if (A.get(start) == target) {
            range.add(1, start);
        } else {
            range.add(0, -1);
            range.add(1, -1);
            return range;
        }
        
        return range;
        
    }
}

/*
ArrayList.add(index, value) - add value for the first time
ArrayList.set(index, value) - update value
*/