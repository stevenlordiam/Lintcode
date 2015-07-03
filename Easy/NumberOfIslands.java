/*
Given a boolean 2D matrix, find the number of islands.

Have you met this question in a real interview? Yes
Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

Note
0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent
*/

public class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    private int n, m;
    
    private void removeIsland(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (grid[nextX][nextY] == '1') {
                    removeIsland(grid, nextX, nextY);
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        
        m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
}