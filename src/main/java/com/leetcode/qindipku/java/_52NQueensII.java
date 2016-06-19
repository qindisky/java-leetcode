package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * @author qindi
 *
 */
public class _52NQueensII {
    
    public int totalNQueens(int n) {
        int[] ret = new int[1], arr = new int[n];
        
        reback(ret, arr, 0);
        
        return ret[0];
    }
    
    private void reback(int[] ret, int[] arr, int i) {
        if (i == arr.length) {
            ret[0]++;
            return;
        }
        
        for (int j = 0; j < arr.length; j++) {
            arr[i] = j;
            if (check(arr, i)) {
                reback(ret, arr, i + 1);
            }
        }
    }
    
    private boolean check(int[] arr, int cur) {
        for (int i = 0; i < cur; i++) {
            if (arr[i] == arr[cur] || Math.abs(arr[cur] - arr[i]) == cur - i) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        _52NQueensII solution = new _52NQueensII();
        System.out.println(solution.totalNQueens(4));
    }
}
