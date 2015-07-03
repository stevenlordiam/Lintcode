/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.

Example
Given a matrix:

[
  [1, 2,  3,  4],
  [5, 6,  7,  8],
  [9,10, 11, 12]
]
return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
*/

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int count = matrix.length * matrix[0].length;
        int[] array = new int[count];
        int r = 0, c = 0;
        array[0] = matrix[0][0];
        for (int i = 1; i < count; ) {
            //斜上走到顶
            while(i < count && r - 1 >= 0 && c + 1 < matrix[0].length) {
                array[i++] = matrix[--r][++c];
            }
            //横右走一步，不可横右走时竖下走一步
            if (i < count && c + 1 < matrix[0].length) {
                array[i++] = matrix[r][++c];
            } else if (i < count && r + 1 < matrix.length) {
                array[i++] = matrix[++r][c];
            }
            //斜下走到底
            while(i < count && r + 1 < matrix.length && c - 1 >= 0) {
                array[i++] = matrix[++r][--c];
            }
            //竖下走一步，不可竖下走时横右走一步
            if (i < count && r + 1 < matrix.length) {
                array[i++] = matrix[++r][c];
            } else if (i < count && c + 1 < matrix[0].length) {
                array[i++] = matrix[r][++c];
            }
        }
        return array;
    }
}

/*
http://blog.csdn.net/wutingyehe/article/details/46629087
*/