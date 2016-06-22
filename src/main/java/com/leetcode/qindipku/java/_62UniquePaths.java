package com.leetcode.qindipku.java;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author qindi
 *
 */
public class _62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        
        for (int x = 0; x < m; x++) {
            for (int y = 1; y < n; y++) {
                if (x > 0 && y > 0) {
                    arr[x][y] = arr[x - 1][y] + arr[x][y - 1];
                } else if (y > 0) {
                    arr[x][y] = arr[x][y - 1];
                } else if (x > 0) {
                    arr[x][y] = arr[x - 1][y];
                }
            }
        }
        
        return arr[m - 1][n - 1];
    }
    
    public static void main(String[] args) {
        _62UniquePaths solution = new _62UniquePaths();
        System.out.println(solution.uniquePaths(3, 7));
    }
}
