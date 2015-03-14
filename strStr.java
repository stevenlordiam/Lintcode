/*
strstr (a.k.a find sub string), is a useful function in string operation. You task is to implement this function. 

For a given source string and a target string, you should output the "first" index(from 0) of target string in source string.

If target is not exist in source, just return -1.

Example
If source="source" and target="target", return -1.

If source="abcdabcdefg" and target="bcd", return 1.

Challenge
O(n) time.

Clarification
Do I need to implement KMP Algorithm in an interview?
- Not necessary. When this problem occurs in an interview, the interviewer just want to test your basic implementation ability.

Tags - Basic Implementation / String
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source, or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source==null || target==null) return -1;
        if(source.equals(target)||target.length()==0) return 0;
        if(target.length()>source.length()) return -1;
        
        for(int i=0;i<source.length()-target.length()+1;i++){
            for(int j=0;j<target.length();j++){
                if(source.charAt(i+j)!=target.charAt(j)) break; 		// if not equal, jump out of loop, otherwise j increases until the end(needle.length()-1), in this case, it's matched
                if(j==target.length()-1) return i;			// i is the index
            }
        }
        return -1;
    }
}

/*
Leetcode - (28) - Implement strStr()



*/