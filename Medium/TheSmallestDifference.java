/*
Given two array of integers(the first array is array A, the second array is array B), now we are going to find a element in array A which is A[i], and another element in array B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.

Have you met this question in a real interview? Yes
Example
For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0

Challenge
O(n log n) time
*/

// Solution 1: 将两个array合并，排序后比较相邻的两个数即可
public class Solution {
    public int smallestDifference(int[] A, int[] B) {
        ArrayList<Node> nodes = new ArrayList<Node>(A.length + B.length);
        for (int a : A) {
            nodes.add(new Node(a, true));
        }
        for (int b : B) {
            nodes.add(new Node(b, false));
        }
        Collections.sort(nodes, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            if (i + 1 < nodes.size() && nodes.get(i).fromA != nodes.get(i+1).fromA) {
                res = Math.min(res, nodes.get(i+1).val - nodes.get(i).val);
            }
        }
        return res;
    }
    class Node {
        int val;
        boolean fromA;
        public Node(int val, boolean fromA) {
            this.val = val;
            this.fromA = fromA;
        }
    }
}

// Solution 2:将两个array分别排序，再用two pointers比较两个元素
public class Solution {
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int p1 = 0, p2 = 0;
        int res = Integer.MAX_VALUE;
        while (p1 < A.length && p2 < B.length) {
            if (A[p1]<=B[p2]) {
                res = Math.min(res, B[p2] - A[p1++]);
                if (p1< A.length && A[p1] > B[p2]) {
                    res = Math.min(res, A[p1] - B[p2]);
                }
            } else {
                res = Math.min(res, A[p1] - B[p2++]);
                if (p2 < B.length && B[p2] > A[p1]) {
                    res = Math.min(res, B[p2] - A[p1]);
                }
            }
        }
        return res;
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/21/lintcode-the-smallest-difference/
http://blog.csdn.net/wangyuquanliuli/article/details/45725045
*/