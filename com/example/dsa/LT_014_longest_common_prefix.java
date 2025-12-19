package com.example.dsa;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
*/

public class LT_014_longest_common_prefix {
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        String longestPrefix = longestCommonPrefix(strs);
        System.out.println(longestPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        int noOfStrs = strs.length;
	
	    StringBuilder sb = new StringBuilder();
	
        for (int pos=0;;pos++) {
            char temp=' ';
            for(int i=0; i<noOfStrs; i++) {
                if (pos >= strs[i].length()) {
                    return sb.toString();
                }
                
                if (i == 0) {
                    temp = strs[i].charAt(pos);
                    continue;
                }
                
                if (temp != strs[i].charAt(pos)) {
                    return sb.toString();
                }
            }
            sb.append(temp);
        }
    }
}
