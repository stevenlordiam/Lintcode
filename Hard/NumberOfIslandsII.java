/*
Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.

Have you met this question in a real interview? Yes
Example
Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
return [1,1,2,2].

Note
0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int n, int m){
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < m; j++) {
                    int id = converttoId(i,j,m);
                    father.put(id, id); 
                }
            }
        }
        int find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = father.get(x);
            while(fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;
                
        }
        
        void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
    
    int converttoId(int x, int y, int m){
        return x*m + y;
    }
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        int []dx = {0,-1, 0, 1};
        int []dy = {1, 0, -1, 0};
        int [][]island = new int[n][m];
        List<Integer> ans = new ArrayList<Integer>();
        UnionFind uf = new UnionFind(n, m);
        int count = 0;
        if(operators != null) {
        for(int i = 0; i < operators.length; i++) {
            count ++;
            int x = operators[i].x;
            int y = operators[i].y;
            if(island[x][y] != 1){
                island[x][y]  = 1;
                int id = converttoId(x,y , m);
                for(int j = 0 ; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1) 
                    {
                        int nid = converttoId(nx, ny, m);
                        
                        int fa = uf.find(id);
                        int nfa = uf.find(nid);
                        if(fa != nfa) {
                            count--;
                            uf.union(id, nid);
                        }
                    }
                }
            }
            ans.add(count);
        }
        }
        return ans;
    }
}