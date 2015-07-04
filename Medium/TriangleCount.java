/*
Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

Example
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]
*/

public class Solution {
    public int triangleCount(int S[]) {
        if (S == null || S.length <= 2) {
            return 0;
        }
        Arrays.sort(S);
        int res = 0;
        for (int end = S.length - 1; end > 1; end--) {
            int start = 0, mid = end - 1;
            while (start < mid) {
                if (S[start] + S[mid] <= S[end]) {
                        start++;
                } else {
                    res += mid - start;     // key point! Because array is sorted, if S[start] can form a triangle, then the elements between start and mid can also form a triangle
                    mid--;
                }
            }
        }
        return res;
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/21/lintcode-triangle-count/
*/