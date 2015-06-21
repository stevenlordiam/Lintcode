/*
Given n unique integers, number k (1<=k<=n)  and target. Find all possible k integers where their sum is target.

Example
Given [1,2,3,4], k=2, target=5, [1,4] and [2,3] are possible solutions.

http://blog.csdn.net/wankunde/article/details/44058403
http://www.cnblogs.com/EdwardLiu/p/4314783.html
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (A.length < k || k <= 0)
            return list;
        for (int i = 0; i < A.length; i++) {
            if (k == 1) {
                if (A[i] == target) {
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(A[i]);
                    list.add(l);
                    return list;
                }
            } else {
                int[] B = new int[A.length - i - 1];
                System.arraycopy(A, i + 1, B, 0, A.length - i - 1);     // arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
                // Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array
                ArrayList<ArrayList<Integer>> sublist = kSumII(B, k - 1, target - A[i]);
                for (ArrayList<Integer> l : sublist) {
                    l.add(0, A[i]);
                    list.add(l);
                }
            }
        }
        return list;
    }
}