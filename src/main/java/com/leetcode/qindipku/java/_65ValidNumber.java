package com.leetcode.qindipku.java;

import java.util.Arrays;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. 
 * XXX.XXXXeXXXX
 * @author qindi
 *
 */
public class _65ValidNumber {
    public boolean isNumber(String s) {
        boolean dotFlag = false, eFlag = false;
        
        char[] arr = s.trim().toCharArray();
        if (arr.length <= 0) {
            return false;
        }
        
        int i = 0;
        if (arr[i] == '-' || arr[i] == '+') {
            i++;
        }
        
        if (i == arr.length) {
            return false;
        }
        
        while (i < arr.length) {
            if (isDigit(arr[i])) {
                //数字
                i++;
            } else if (arr[i] == '.') {
                //.
                if (!dotFlag && !eFlag) {
                    if (i > 0 && isDigit(arr[i - 1])) {
                        dotFlag = true;
                        i++;
                        continue;
                    } else if (i < arr.length - 1 && isDigit(arr[i + 1])) {
                        dotFlag = true;
                        i++;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (arr[i] == 'e' || arr[i] == 'E') {
                //e
                if (!eFlag) {
                    if (0 == i) {
                        return false;
                    } else if (!isNumber(String.valueOf(arr, 0, i))) {
                        return false;
                    }
                    
                    eFlag = true;
                    i++;
                    break;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        if (eFlag) {
            if (i == arr.length) {
                return false;
            }
            if (arr[i] == '+' || arr[i] == '-') {
                i++;
            }
            if (i == arr.length) {
                return false;
            } else {
                while (i < arr.length) {
                    if (isDigit(arr[i])) {
                        i++;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean isDigit(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        _65ValidNumber solution = new _65ValidNumber();
        System.out.println(solution.isNumber("0"));
        System.out.println(solution.isNumber("0.1"));
        System.out.println(solution.isNumber("abc"));
        System.out.println(solution.isNumber("1 a"));
        System.out.println(solution.isNumber("2e10"));
        System.out.println(solution.isNumber("e"));
        System.out.println(solution.isNumber(" "));
        System.out.println(solution.isNumber("-1."));
        System.out.println(solution.isNumber("+.8"));
        System.out.println(solution.isNumber("46.e3"));
        System.out.println(solution.isNumber("."));
        System.out.println(solution.isNumber("e9"));
        System.out.println(solution.isNumber(".1."));
        System.out.println(solution.isNumber("+E3"));
    }
}
