package com.example.dsa;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
 
Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
*/

public class LT_005_longest_palindromic_substring {
    
    public static void main(String[] args) {
        String s = "ababab";
        String maxPalindrome = longestPalindrome(s);
        System.out.println("Max palindromic sub string: " + maxPalindrome);
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int end = 0;
        int maxLength = 0;
        String maxSubString = "";

        for (int i=0; i<chars.length;i++) {
            start = i;
            end = i;
            
            while (start >=0 && end < chars.length) {
                if (chars[start] != chars[end]) {
                    break;
                }
                
                if ((end - start + 1) > maxLength) {
                    maxLength = (end - start + 1);
                    maxSubString = s.substring(start, end+1);
                }
                
                start --;
                end++;
            }

            if ( (i+1 < chars.length) && chars[i] == chars[i+1]) {
                start = i;
                end = i+1;

                while (start >=0 && end < chars.length) {
                    if (chars[start] != chars[end]) {
                        break;
                    }
                    
                    if ((end - start + 1) > maxLength) {
                        maxLength = (end - start + 1);
                        maxSubString = s.substring(start, end+1);
                    }
                    
                    start --;
                    end++;
                }
            }
        }
        
        return maxSubString;
    }

}