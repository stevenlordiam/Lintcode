/*
Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.

Have you met this question in a real interview? Yes
Example
For A = [1, 2, 3], return [6, 3, 2]
*/

public class Solution {     // 类似best time to buy and sell stock III, 左右扫两次
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        
        if (A == null || A.size() == 0) {
            return result;
        }
        
        long[] left = new long[A.size()];
        long[] right = new long[A.size()];
        left[0] = 1;
        for (int i = 1; i < A.size(); i++) {
            left[i] = left[i-1] * A.get(i-1);
        }
        right[A.size()-1] = 1;
        for (int i = A.size()-2; i >= 0; i--) {
            right[i] = right[i+1] * A.get(i+1);
        }
        for (int i = 0; i < A.size(); i++) {
            result.add(left[i] * right[i]);
        }
        return result;
    }
}

/*
https://richdalgo.wordpress.com/2015/02/01/lintcode-product-of-array-exclude-itself/
http://algorithm.yuanbin.me/integer_array/product_of_array_exclude_itself.html
http://blog.csdn.net/nicaishibiantai/article/details/43305941
*/