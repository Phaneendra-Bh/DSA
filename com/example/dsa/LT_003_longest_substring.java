package com.example.dsa;

import java.util.HashMap;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

public class LT_003_longest_substring {
    
    public static void main(String[] args) {
        String s = "abcabcbb";
        int count = lengthOfLongestSubstring(s);
        System.out.println(count);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
		    return s.length();
	    }
	
	    char[] chars = s.toCharArray();
	
        int start = 0;
        int end = start + 1;
        int maxCount = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(chars[start], 0);
        
        while(end < chars.length) {
            if (map.containsKey(chars[end])) {
                int temp = map.get(chars[end]);
                while (start <= temp) {
                    map.remove(chars[start]);
                    start++;
                }    
            }

            map.put(chars[end], end);
            
            maxCount = Math.max(maxCount, (end-start+1));

            end++;
        }
	
	    return maxCount;
    }
}
