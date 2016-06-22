package com.leetcode.qindipku.java;

/**
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * 
 * @author qindi
 *
 */
public class _63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xLength = obstacleGrid.length, yLength = obstacleGrid[0].length;
        int[][] arr = new int[xLength][yLength];
        
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                if (obstacleGrid[x][y] == 1) {
                    arr[x][y] = 0;
                } else {
                    if (x == 0 && y == 0) {
                        arr[x][y] = 1;
                    } else if (x > 0 && y > 0) {
                        arr[x][y] = arr[x - 1][y] + arr[x][y - 1];
                    } else if (y > 0) {
                        arr[x][y] = arr[x][y - 1];
                    } else if (x > 0) {
                        arr[x][y] = arr[x - 1][y];
                    }
                }
            }
        }
        
        return arr[xLength - 1][yLength - 1];
    }
    
    public static void main(String[] args) {
        _63UniquePathsII solution = new _63UniquePathsII();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
