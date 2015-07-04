/*
Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

Have you met this question in a real interview? Yes
Example
For L=[232, 124, 456], k=7, return 114.

Note
You couldn't cut wood into float length.

Challenge
O(n log Len), where Len is the longest length of the wood
*/

public class Solution {
    public int woodCut(int[] L, int k) {    // binary search
        // write your code here
        int n=L.length;
        if(n==0)
            return 0;
        Arrays.sort(L);
        int res=0;
        int left=1, right=L[n-1];
        while(left<=right){
            int mid=(right-left)/2+left;
            int count=0;
            for(int i=n-1;i>=0;i--)
                count+=(L[i]/mid);
            if(count>=k){
                res=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return res;
    }
}

/*
https://gist.github.com/wkkustc/224b5deab613e569c87e
http://algorithm.yuanbin.me/binary_search/wood_cut.html
https://codesolutiony.wordpress.com/2015/03/10/lintcode-183-wood-cut/
http://www.jiuzhang.com/solutions/wood-cut/
http://blog.csdn.net/wangyuquanliuli/article/details/45788783
*/