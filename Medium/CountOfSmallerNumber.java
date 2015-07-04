/*
Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. For each query, give you an integer, return the number of element in the array that are smaller that the given integer.

Have you met this question in a real interview? Yes
Example
For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]

Note
We suggest you finish problem Segment Tree Build and Segment Tree Query II first.

Challenge
Could you use three ways to do it.

Just loop
Sort and binary search
Build Segment Tree and Search
*/

// Solution 1: binary search
public class Solution { 	
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        Arrays.sort(A);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int q : queries) {
            res.add(binarySearch(A, q));    // index is the number of elements smaller than the given integer
        }
        return res;
    }

    private int binarySearch(int[] A, int val) {
        int start = 0, end = A.length - 1;
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] >= val) {
                end = mid - 1;
            } else {
                res = mid + 1;
                start = mid + 1;
            }
        }
        return res;
    }
}

// Solution 2: Segment tree
public class Solution {
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || queries == null || queries.length == 0) {
            return res;
        }
        Arrays.sort(A);
        MaxNode root = buildTree(A, 0, A.length - 1);
         
        for (int q : queries) {
            res.add(query(A, root, q));
        }
        return res;
    }
    private MaxNode buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        MaxNode root = new MaxNode(start, end);
        if (start == end) {
            root.val = A[start];
        } else {
            root.left = buildTree(A, start, (start+end)/2);
            root.right = buildTree(A, (start+end)/2+1, end);
            root.val = root.left == null ? root.right.val : Math.max(root.left.val,
                root.right == null ? 0 : root.right.val);
        }
        return root;
    }
    private int query(int[] A, MaxNode root, int val) {
        if (root == null || A[root.start] > val) {
            return 0;
        }
        if (root.val < val) {
            return root.end - root.start + 1;
        }
        return query(A, root.left, val) + query(A, root.right, val);
    }
    class MaxNode {
        int start;
        int end;
        int val; //how many nodes are between the range start - end (inclusive)
        MaxNode left;
        MaxNode right;
        public MaxNode() {
             
        }
        public MaxNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public MaxNode(int start, int end, int val) {
            this(start, end);
            this.val = val;
        }
    }
}