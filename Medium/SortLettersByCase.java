/*
Given a string which contains only letters. Sort it by lower case first and upper case second.

Have you met this question in a real interview? Yes
Example
For "abAcD", a reasonable answer is "acbAD"

Note
It's not necessary to keep the original order of lower-case letters and upper case letters.

Challenge
Do it in one-pass and in-place.
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int low = 0; 
        int cap = chars.length-1;
        while (low < cap) {
            while (low < cap && chars[low] >= 'a' && chars[low] <= 'z') {
                low++;
            }
            while (low < cap && chars[cap] >= 'A' && chars[cap] <= 'Z') {
                cap--;
            }
            char tmp = chars[low];
            chars[low] = chars[cap];
            chars[cap] = tmp;
        }
    }
}

/*
http://www.cnblogs.com/lishiblog/p/4196831.html
http://blog.csdn.net/nicaishibiantai/article/details/43634769
https://codesolutiony.wordpress.com/2015/05/28/lintcode-sort-letters-by-case/
*/