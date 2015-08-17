/*
strstr (a.k.a find sub string), is a useful function in string operation. You task is to implement this function. 
*/

public class Solution {
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (source.length() < target.length()) {
            return -1;
        }
        
        int j;      // define j here or line 47 cannot find j !!!
        for (int i = 0; i < source.length() - target.length() + 1; i++) {   // REMEMBER + 1 !!!
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i+j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                    return i;
            }
        }
        return -1;
    }
}

/*
String length: string.length()
Array length: array.length
ArrayList length: arraylist.size()
*/