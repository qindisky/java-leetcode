package com.leetcode.qindipku.java;

/**
 * 64. Minimum Path Sum
 * 
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author qindi
 *
 */
public class _64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int xLength = grid.length, yLength = grid[0].length;
        int[][] arr = new int[xLength][yLength];
        
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                if (x == 0 && y == 0) {
                    arr[x][y] = grid[0][0];
                } else if (x > 0 && y > 0) {
                    arr[x][y] = Math.min(arr[x - 1][y] + grid[x][y], arr[x][y - 1] + grid[x][y]);
                } else if (y > 0) {
                    arr[x][y] = arr[x][y - 1] + grid[x][y];
                } else if (x > 0) {
                    arr[x][y] = arr[x - 1][y] + grid[x][y];
                }
            }
        }
        
        return arr[xLength - 1][yLength - 1];
    }
    
    public static void main(String[] args) {
        _64MinimumPathSum solution = new _64MinimumPathSum();
        System.out.println(solution.minPathSum(new int[][]{{1,2,3},{1,2,1}}));
    }
}
