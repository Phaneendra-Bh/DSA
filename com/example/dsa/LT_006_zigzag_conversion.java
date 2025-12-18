package com.example.dsa;

import java.lang.StringBuilder;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"
 
Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
*/

public class LT_006_zigzag_conversion {
    
    public static void main(String[] args) {
        String s = "AB";
        int n = 2;

        String zigzagStr = convert(s, n);
        System.out.println(zigzagStr);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
            strs[i] = new StringBuilder();
        }
	
        int length = s.length();
        int pos = 0;
        int workingLength = 0;
        boolean isFwd = true;
	
        while(pos < length) {
            strs[workingLength] = strs[workingLength].append(s.charAt(pos));
            
            if (workingLength == numRows-1) {
                isFwd = false;
            } else if (workingLength == 0) {
                isFwd = true;
            }
            
            if (isFwd) {
                workingLength++;
            } else {
                workingLength--;
            }
            
            pos++;
        }
	
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<numRows;i++) {
            sb.append(strs[i].toString());
        }
	
	    return sb.toString();
    }
}
