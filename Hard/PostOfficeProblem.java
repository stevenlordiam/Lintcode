/*
On one line there are n houses. Give you an array of integer means the the position of each house. 
Now you need to pick k position to build k post office, so that the sum distance of each house to the nearest post office is the smallest. 
Return the least possible sum of all distances between each village and its nearest post office.

Example
Given array a = [1,2,3,4,5], k = 2. return 3.

Challenge
Could you solve this problem in O(n^2) time ?
*/

public class Solution {
    public int [][]init(int []A) {  
        int n = A.length;
        int [][]dis = new int [n+1][n+1];
        for(int i = 1; i <= n; i++) {  
            for(int j = i+1 ;j <= n;++j)  
            {  
                int mid = (i+j) /2;  
                for(int k = i;k <= j;++k)  
                    dis[i][j] += Math.abs(A[k - 1] - A[mid - 1]);  
            } 
        }
        return dis; 
    } 
    
    public int postOffice(int[] A, int k) {
        int n = A.length;
        Arrays.sort(A);

        int [][]dis = init(A);
        int [][]dp = new int[n + 1][k + 1];
        if(n == 0 || k >= A.length)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i <= n;++i) {
            dp[i][1] = dis[1][i];

        }
        
        for(int nk = 2; nk <= k; nk++) {
            for(int i = nk; i <= n; i++) {
                dp[i][nk] = Integer.MAX_VALUE;
                for(int j = 0; j < i; j++) {  
                    if(dp[i][nk] == Integer.MAX_VALUE || dp[i][nk] > dp[j][nk-1] + dis[j+1][i]) {
                    	dp[i][nk] = dp[j][nk-1] + dis[j+1][i];   
                    }   
                }  
            }
        }
        return dp[n][k];
    }
}

/*
http://www.jiuzhang.com/solutions/post-office-problem/
http://blog.csdn.net/find_my_dream/article/details/4931222
https://github.com/kamyu104/LintCode/blob/master/C++/post-office-problem.cpp
*/