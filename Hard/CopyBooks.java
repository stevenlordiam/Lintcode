/*
Given an array A of integer with size of n( means n books and number of pages of each book) and k people to copy the book. 
You must distribute the continuous id books to one people to copy. 
(You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is not continuous.) 
Each person have can copy one page per minute. Return the number of smallest minutes need to copy all the books.

Example
Given array A = [3,2,4], k = 2.
Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )

Challenge
Could you do this in O(n*k) time ?
*/

public class Solution {
    public int [][]init(int []A) {  
        int n = A.length;
        int [][]w = new int [n+2][n+2];
        for(int i = 1; i <= n; i++) {  
            for(int j = i+1; j <= n; j++)  
            {  
                for(int k = i;k <= j;++k) {
                    w[i][j] += A[k - 1];  
                }
            } 
        }
        return w; 
    } 
    
    public int copyBooks(int[] pages, int k) {
        int n = pages.length;
        int [][]w = init(pages);
        int [][]dp = new int[n + 2][k + 2];
        int [][]s = new int[n + 2][k + 2];
        
        int ans = Integer.MIN_VALUE;
        if(n <= k) {
            for(int i = 0; i < n; i++) 
             ans = Math.max(ans, pages[i]);
            return ans;
        }
        
        for(int i = 0;i <= n;++i)  {
            dp[i][1] = w[1][i];  
        }
        
        for(int nk = 2; nk <= k; nk++) {
            for(int i = nk; i <= n; i++) {
                dp[i][nk] = Integer.MAX_VALUE;
                for(int j = 0; j < i; j++) {  
                    if(dp[i][nk] == Integer.MAX_VALUE || dp[i][nk] > Math.max(dp[j][nk-1], w[j+1][i])) {
                    	dp[i][nk] = Math.max(dp[j][nk-1], w[j+1][i]);   
                    }     
                }  
            }
        }
        return dp[n][k];
    }
}

/*
http://www.jiuzhang.com/solutions/copy-books/
http://jane4532.blogspot.com/2015/07/lintcode-copy-books.html
https://github.com/kamyu104/LintCode/blob/master/C++/copy-books.cpp
*/