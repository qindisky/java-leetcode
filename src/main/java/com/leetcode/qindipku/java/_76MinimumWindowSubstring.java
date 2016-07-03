package com.leetcode.qindipku.java;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *  
 *  For example,
 *  S = "ADOBECODEBANC"
 *  T = "ABC"
 *  
 *  Minimum window is "BANC".
 *  
 *  Note:
 *  
 *  If there is no such window in S that covers all characters in T, return the empty string "".
 *  
 *  If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
 * 
 * @author qindi
 *
 */
public class _76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> foundMap = new HashMap<Character, Integer>(), markMap = new HashMap<Character, Integer>();
        
        //init markMap to remember count of char in t
        for (char c : t.toCharArray()) {
            if (markMap.containsKey(c)) {
                markMap.put(c, markMap.get(c) + 1);
            } else {
                markMap.put(c, 1);
                foundMap.put(c, 0);
            }
        }
        
        int begin = 0, end = 0;
        int minLength = Integer.MAX_VALUE, foundLength = 0;
        int start = -1;
        
        for (end = 0; end < s.length(); end++) {
            char sc = s.charAt(end);
            
            if (markMap.containsKey(sc)) {
                foundMap.put(sc, foundMap.get(sc) + 1);
                
                if (foundMap.get(sc) <= markMap.get(sc)) {
                    foundLength++;
                }
                
                if (foundLength == t.length()) {
                    char cBegin = s.charAt(begin);
                    while (!markMap.containsKey(cBegin) || foundMap.get(cBegin) > markMap.get(cBegin)) {
                        if (foundMap.containsKey(cBegin)
                                && foundMap.get(cBegin) > markMap.get(cBegin)) {
                            foundMap.put(cBegin, foundMap.get(cBegin) - 1);
                        }
                        begin++;
                        cBegin = s.charAt(begin);
                    }
                    
                    if (minLength > end - begin + 1) {
                        start = begin;
                        minLength = end - begin + 1;
                    }
                }
            }
        }
        
        String result = "";
        if (start >= 0 && minLength < Integer.MAX_VALUE) {
            result = s.substring(start, start + minLength);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        _76MinimumWindowSubstring solution = new _76MinimumWindowSubstring();
        //System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
    }
}
