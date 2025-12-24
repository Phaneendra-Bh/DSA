package com.example.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
*/

public class LT_049_group_anagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //String[] strs = {""};

        List<List<String>> result = groupAnagrams(strs);

        for (List<String> group: result) {
            for (String s: group) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            String canonicalStr = sort(str);
            map.computeIfAbsent(canonicalStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams_old(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
	
	    List<List<String>> result = new ArrayList<>();
	
        String tempStr;
        int nextIndex = 0;
        for (int i=0; i<strs.length; i++) {
            tempStr = sort(strs[i]);
            if(map.containsKey(tempStr)) {
                int pos = map.get(tempStr);
                if (pos >= result.size()) {
                    result.add(new ArrayList<String>());
                }
                result.get(pos).add(strs[i]);
            } else {
                map.put(tempStr, nextIndex);
                result.add(new ArrayList<String>());
                result.get(nextIndex).add(strs[i]);
                nextIndex++;
            }
        }
	
	    return result;
    }

    public static String sort(String s) {
        char[] chars = new char[26];

        for(char c: s.toCharArray()) {
            chars[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == 0) continue;
            
            while (chars[i] > 0) {
                sb.append((char)('a' + i));
                chars[i]--;
            }
        }
        return sb.toString();
    }
}
