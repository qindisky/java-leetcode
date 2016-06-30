package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 *  
 *  You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 *  
 *  Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *  
 *  For the last line of text, it should be left justified and no extra space is inserted between words. 
 * 
 * @author qindi
 *
 */
public class _68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        
        int left = 0, right = 0, sum = 0, count = 0;
        while (right < words.length) {
            if (words[right] == "") {
                right++;
                continue;
            } else if (sum + words[right].length() + right - left <= maxWidth) {
                sum += words[right].length();
                right++;
                count++;
            } else {
                int rest = maxWidth - sum;
                int avgSpaces = count == 1 ? rest : rest / (count - 1);
                StringBuilder avgSpacesStr = new StringBuilder();
                while (avgSpaces-- > 0) {
                    avgSpacesStr.append(" ");
                }
                int extraSpaceNum = count == 1 ? 0 : rest % (count - 1);
                StringBuilder sb = new StringBuilder();
                while (left < right) {
                    if (words[left] == "") {
                        left++;
                        continue;
                    }
                    sb.append(words[left]).append(avgSpacesStr);
                    left++;
                    if (extraSpaceNum > 0) {
                        sb.append(" ");
                        extraSpaceNum--;
                    }
                }
                
                if (count == 1) {
                    result.add(sb.toString());
                } else {
                    result.add(sb.toString().trim());
                }
                sum = 0;
                count = 0;
            }
        }

        String str = "";
        while (left < right) {
            if (words[left] == "") {
                left++;
                continue;
            }
            str += words[left++] + " ";
        }
        str = str.trim();
        for (int i = str.length(); i < maxWidth; i++) {
            str += " ";
        }
        result.add(str);
        
        return result;
    }
    
    public static void main(String[] args) {
        _68TextJustification solution = new _68TextJustification();
        //System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(solution.fullJustify(new String[]{""}, 0));
        System.out.println(solution.fullJustify(new String[]{""}, 2));
    }
}
