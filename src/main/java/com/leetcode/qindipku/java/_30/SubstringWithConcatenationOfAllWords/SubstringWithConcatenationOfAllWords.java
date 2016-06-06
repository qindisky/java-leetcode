package com.leetcode.qindipku.java._30.SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters. For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author qindi
 *
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        if (null == s || s.length() == 0 || null == words || words.length == 0) {
            return ret;
        }

        Map<String, Integer> oriMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (!oriMap.containsKey(word)) {
                oriMap.put(word, 1);
            } else {
                oriMap.put(word, oriMap.get(word) + 1);
            }
        }
        Map<String, Integer> curMap = new HashMap<String, Integer>(oriMap.size());

        int width = words[0].length(), targetCount = words.length;
        for (int i = 0; i < width; i++) {
            curMap.clear();
            int left = i, count = 0;

            for (int j = left; j <= s.length() - width; j += width) {
                String subStr = s.substring(j, j + width);

                if (oriMap.containsKey(subStr)) {
                    if (!curMap.containsKey(subStr)) {
                        curMap.put(subStr, 1);
                    } else {
                        curMap.put(subStr, curMap.get(subStr) + 1);
                    }

                    count++;
                    while (curMap.get(subStr) > oriMap.get(subStr)) {
                        String leftStr = s.substring(left, left + width);
                        curMap.put(leftStr, curMap.get(leftStr) - 1);
                        left += width;
                        count--;
                    }

                    if (count == targetCount) {
                        ret.add(left);
                        String leftStr = s.substring(left, left + width);
                        curMap.put(leftStr, curMap.get(leftStr) - 1);
                        left += width;
                        count--;
                    }

                } else {
                    curMap.clear();
                    count = 0;
                    left = j + width;
                }
            }
        }

        return ret;
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        if (null == s || s.length() == 0 || null == words || words.length == 0) {
            return ret;
        }

        boolean flag[];
        Map<String, Integer> map = new HashMap<String, Integer>();
        int width = words[0].length();
        int targetLength = width * words.length;

        for (int i = 0; i < s.length(); i++) {
            int j = i;
            flag = new boolean[words.length];
            StringBuilder sb = new StringBuilder();

            while (j < s.length() - width + 1) {
                String subStr = s.substring(j, j + width);
                boolean go = false;

                // find if subStr in the words
                for (int k = 0; k < words.length; k++) {
                    if (subStr.equals(words[k]) && !flag[k]) {
                        j += width;
                        flag[k] = true;
                        sb.append(subStr);
                        go = true;
                        break;
                    }
                }

                if (go) {
                } else {
                    break;
                }

            }

            // find a concatenation
            if (targetLength == sb.length() && !map.containsKey(sb.toString())) {
                map.put(sb.toString(), i);
                ret.add(i);
            }
        }

        return ret;
    }

    public static void main(String args[]) {
        boolean flag[] = new boolean[2];
        for (boolean b : flag) {
            System.out.println(b);
        }
        System.out.println("abc".substring(0, 2));
    }

}
