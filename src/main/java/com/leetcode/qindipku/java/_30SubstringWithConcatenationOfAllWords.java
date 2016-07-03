package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  You are given a string, s, and a list of words, words, that are all of the same length. 
 *  Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once 
 *  and without any intervening characters.
 *  
 *  For example, given:
 *  s: "barfoothefoobarman"
 *  words: ["foo", "bar"]
 *  
 *  You should return the indices: [0,9].
 *  (order does not matter). 
 * 
 * @author qindi
 *
 */
public class _30SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        
        Map<String, Integer> markMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (markMap.containsKey(word)) {
                markMap.put(word, markMap.get(word) + 1);
            } else {
                markMap.put(word, 1);
            }
        }
        
        int wordLength = words[0].length();
        for (int i = 0; i < words[0].length(); i++) {
            Map<String, Integer> foundMap = new HashMap<String, Integer>();
            int found = 0;
            
            for (int left = i, right = i; right < s.length() - wordLength + 1; right += wordLength) {
                String word = s.substring(right, right + wordLength);
                
                if (markMap.containsKey(word)) {
                    if (foundMap.containsKey(word)) {
                        foundMap.put(word, foundMap.get(word) + 1);
                    } else {
                        foundMap.put(word, 1);
                    }
                    
                    if (foundMap.get(word) <= markMap.get(word)) {
                        found++;
                    } else {
                        String leftWord = s.substring(left, left + wordLength);
                        while (foundMap.get(word) > markMap.get(word)) {
                            if (foundMap.get(leftWord) <= markMap.get(leftWord)) {
                                found--;
                            }
                            foundMap.put(leftWord, foundMap.get(leftWord) - 1);
                            left += wordLength;
                            leftWord = s.substring(left, left + wordLength);
                        }
                    }
                    
                    if (found == words.length) {
                        result.add(left);
                    }
                } else {
                    foundMap.clear();
                    found = 0;
                    left = right + wordLength;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        _30SubstringWithConcatenationOfAllWords solution = new _30SubstringWithConcatenationOfAllWords();
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"}));
    }
}
