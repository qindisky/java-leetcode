package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * 
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * 
 * @author qindi
 *
 */
public class _49GroupAnagrams {
    
    public List<List<String>> groupAnagramsBest(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);

            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] arr = new int[26];
        
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            arr = new int[26];
            for (char c : str.toCharArray()) {
                arr[c - 'a'] += 1;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    sb.append((char) ('a' + i)).append(arr[i]);
                }
            }
            System.out.println(sb.toString());
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<String>());
            }
            
            map.get(sb.toString()).add(str);
        }
        
        List<List<String>> ret = new ArrayList<List<String>>(map.values());
        return ret;
    }
    
    public static void main(String[] args) {
        _49GroupAnagrams solution = new _49GroupAnagrams();
        System.out.println(solution.groupAnagramsBest(new String[]{"huh","tit"}));
        System.out.println(solution.groupAnagrams(new String[]{"huh","tit"}));
    }
}
