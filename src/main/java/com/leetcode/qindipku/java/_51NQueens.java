package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * @author qindi
 *
 */
public class _51NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> store = new ArrayList<List<String>>();
        
        return store;
    }
    
    public List<List<String>> solveNQueensNormal(int n) {
        List<List<String>> store = new ArrayList<List<String>>();
        
        int[][] arr = new int[n][n];
        
        reback(store, arr, 0);
        
        return store;
    }
    
    private void reback(List<List<String>> store, int[][] arrs, int i) {
        if (i == arrs.length) {
            List<String> result = new ArrayList<String>(arrs.length);
            for (int[] arr : arrs) {
                StringBuilder sb = new StringBuilder();
                for (int num : arr) {
                    if (num == 1) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                result.add(sb.toString());
            }
            store.add(result);
            return;
        }
        
        for (int j = 0; j < arrs.length; j++) {
            arrs[i][j] = 1;
            if (check(arrs, i, j)) {
                reback(store, arrs, i + 1);
            }
            arrs[i][j] = 0;
        }
    }
    
    private boolean check(int[][] arrs, int x, int y) {
        for (int j = 0; j < y; j++) {
            if (arrs[x][j] == 1) {
                return false;
            }
        }
        
        for (int i = 0; i < x; i++) {
            if (arrs[i][y] == 1) {
                return false;
            }
        }
        
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0;) {
            if (arrs[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        
        for (int i = x - 1, j = y + 1; i >= 0 && j < arrs.length;) {
            if (arrs[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        _51NQueens solution = new _51NQueens();
        System.out.println(solution.solveNQueensNormal(4));
    }
}
