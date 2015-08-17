/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example
There exist two distinct solutions to the 4-queens puzzle:
[
    [".Q..", // Solution 1
     "...Q",
     "Q...",
     "..Q."],
    ["..Q.", // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
]

Challenge
Can you do it without recursion?
*/

public class Solution {     // O(N!)
    private String[] drawChessboard(ArrayList<Integer> cols) {      // cols - 在第i行，把queen放在了result位置上
        String[] chessboard = new String[cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            chessboard[i] = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    chessboard[i] += "Q";
                } else {
                    chessboard[i] += ".";
                }
            }
        }
        
        return chessboard;
    }
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            // same column
            if (cols.get(i)== col)  {
                return false;
            }
            // left-top to right-bottom
            if (i - cols.get(i) == row - col) {
                return false;
            }
            // right-top to left-bottom
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    
    private void search(int n, ArrayList<Integer> cols, ArrayList<String[]> result) {
        if (cols.size() == n) {
            result.add(drawChessboard(cols));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(n, cols, result);
            cols.remove(cols.size() - 1);
        }
    }
    
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
            return result;
        }
        search(n, new ArrayList<Integer>(), result);
        return result;
    }
}