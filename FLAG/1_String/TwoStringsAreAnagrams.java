/*
Write a method anagram(s,t) to decide if two strings are anagrams or not.

Have you met this question in a real interview? Yes
Example
Given s="abcd", t="dcab", return true.

Challenge
O(n) time, O(1) extra space
*/

public class Solution {
    // version 1
    public boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
           return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;     // char to int
        }
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    // version 2, sort array, O(nlogn)
    public boolean anagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        s = String.valueOf(sArray);
        t = String.valueOf(tArray); 
        return s.equals(t);
    }
}