/*
Given a (decimal - e.g. 3.72) number that is passed in as a string, return the binary representation that is passed in as a string. If the number can not be represented accurately in binary with at most 32 characters, return ERROR.

Have you met this question in a real interview? Yes
Example
For n = "3.72", return "ERROR".

For n = "3.5", return "11.1"
*/

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
     
    private String parseInteger(String str) {
        int n = Integer.parseInt(str);
        if (str.equals("") || str.equals("0")) {
            return "0";
        }
        String binary = "";
        while (n != 0) {
            binary = Integer.toString(n % 2) + binary;
            n = n / 2;
        }
        return binary;
    }
    
    private String parseFloat(String str) {
        double d = Double.parseDouble("0." + str);
        String binary = "";
        HashSet<Double> set = new HashSet<Double>();
        while (d > 0) {
            if (binary.length() > 32 || set.contains(d)) {
                return "ERROR";
            }
            set.add(d);
            d = d * 2;
            if (d >= 1) {
                binary = binary + "1";
                d = d - 1;
            } else {
                binary = binary + "0";
            }
        }
        return binary;
    }
    
    public String binaryRepresentation(String n) {
        if (n.indexOf('.') == -1) {
            return parseInteger(n);
        }
        String[] params = n.split("\\.");
        String flt = parseFloat(params[1]);
        if (flt == "ERROR") {
            return flt;
        }
        if (flt.equals("0") || flt.equals("")) {
            return parseInteger(params[0]);
        }
        return parseInteger(params[0]) + "." + flt;
    }
}