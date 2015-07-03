/*
Given number n. Print number from 1 to n. But:

when number is divided by 3, print "fizz".
when number is divided by 5, print "buzz".
when number is divided by both 3 and 5, print "fizz buzz".
Have you met this question in a real interview? Yes
Example
If n = 15, you should return:

["1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz"]
*/

public class Solution {
    /**
     * param n: As description.
     * return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i=1; i<=n; i++) {
            StringBuffer buf = new StringBuffer();
            if (i%3==0 && i%5!=0) {
                buf.append("fizz");
            }
            if (i%3!=0 && i%5==0) {
                buf.append("buzz");
            }
            if (i%3==0 && i%5==0) {
                buf.append("fizz buzz");
            }
            if (i%3!=0 && i%5!=0) {
                buf.append(i);
            }
            res.add(buf.toString());
        }
        return res;
    }
}