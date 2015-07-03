/*
Given a dictionary, find all of the longest words in the dictionary.

Example
Given
{
  "dog",
  "google",
  "facebook",
  "internationalization",
  "blabla"
}
the longest words are(is) ["internationalization"].

Given

{
  "like",
  "love",
  "hate",
  "yes"
}
the longest words are ["like", "love", "hate"].

Challenge
It's easy to solve it in two passes, can you do it in one pass?
*/

public class Solution {
    public ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> res = new ArrayList<String>();
        for (String str : dictionary) {
            if (res.isEmpty() || res.get(0).length() < str.length()) {
                res.clear();  // remove all of the elements from the list
                res.add(str);
            } else if (res.get(0).length() == str.length()) {
                res.add(str);
            }
        }
        return res;
    }
}