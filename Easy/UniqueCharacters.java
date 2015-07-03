/*
Implement an algorithm to determine if a string has all unique characters.

Have you met this question in a real interview? Yes
Example
Given "abc", return true.

Given "aab", return false.

Challenge
What if you can not use additional data structures?
*/

public class Solution {
    public static boolean isUnique(String str){
		for(int i=0;i<str.length();i++){	
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(j)==str.charAt(i)){			
					return false;
				}
			}	
		}
		return true;
	}
}

// CC150 1.1