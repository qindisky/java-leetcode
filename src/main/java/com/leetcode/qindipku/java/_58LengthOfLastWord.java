package com.leetcode.qindipku.java;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example,
 * Given s = "Hello World",
 * return 5. 
 * 
 * @author qindi
 *
 */
public class _58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (null == s){
            return 0;
        }
        
        int length = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && length == 0) {
                continue;
            } else if (s.charAt(i) == ' ' && length > 0) {
                break;
            } else {
                length++;
            }
        }
        
        return length;
    }
    
    public static void main(String[] args) {
        _58LengthOfLastWord solution = new _58LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World  "));
    }
}
