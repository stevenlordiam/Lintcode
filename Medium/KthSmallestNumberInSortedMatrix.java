/*
Find the kth smallest number in at row and column sorted matrix.

Have you met this question in a real interview? Yes
Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5

Challenge
O(k log n), n is the maximal number in width and height
*/

public class Solution {
    public int kthSmallest(final int[][] matrix, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]);
            }
        });
        heap.add(new int[]{0,0});
        visited[0][0] = true;
        while (k > 1) {
            int[] res = heap.remove();
            int x = res[0];
            int y = res[1];
             
             
            if (x+1 < matrix.length && visited[x+1][y] == false) {
                visited[x+1][y] = true;
                heap.add(new int[]{x+1, y});
            }
            if (y+1 < matrix[0].length && visited[x][y+1] == false) {
                visited[x][y+1] = true;
                heap.add(new int[]{x, y+1});
            }
            k--;
        }
        int[] res = heap.remove();
        return matrix[res[0]][res[1]];
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/31/lintcode-kth-smallest-number-in-sorted-matrix/
http://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
https://github.com/kamyu104/LintCode/blob/master/C++/kth-smallest-number-in-sorted-matrix.cpp
*/