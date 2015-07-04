/*
Given a string s, find the length of the longest substring T that contains at most k distinct characters.

Have you met this question in a real interview? Yes
Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.

Challenge
O(n), n is the size of the string s
*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        int start = 0;
        int res = 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 1);
        for (int end = 1; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                if (map.size() == k) {
                    res = Math.max(res, end - start);
                    // full map, need to remove the first character in ths substring
                    for (int index = start; index < end; index++) {
                        map.put(s.charAt(index), map.get(s.charAt(index))-1);
                        start++;
                        if (map.get(s.charAt(index)) == 0) {
                            // have removed all occurance of a char
                            map.remove(s.charAt(index));
                            break;
                        }
                    }
                }
                map.put(ch, 1);
            }
        }
        res = Math.max(res, s.length() - start);
        return res;
    }
}

/*
解法是维护一个sliding window，以及一个hash map， key是char，value是这个char在当前window中得出现次数。
start和end是当前字符串的起始和终止index。
当当前window 字符数超过k的时候，从start开始remove，只要遇到一个char的个数降为0的时候，可以跳出，因为说明当前window的char个数已经为k-1,满足条件。
如果字符集比较小的话可以维护一个int[]来对char计数

https://codesolutiony.wordpress.com/2015/05/22/lintcode-longest-substring-with-at-most-k-distinct-characters/
http://blog.csdn.net/martin_liang/article/details/45648985
http://www.cnblogs.com/lishiblog/p/4160854.html
http://hehejun.blogspot.com/2015/01/leetcodelongest-substring-with-at-most.html
http://www.danielbit.com/blog/puzzle/leetcode/leetcode-longest-substring-with-at-most-two-distinct-characters
http://massivealgorithms.blogspot.com/2014/12/leetcode-longest-substring-with-at-most.html
*/