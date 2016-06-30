package com.leetcode.qindipku.java;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,
 * Consider the following matrix:
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * @author qindi
 *
 */
public class _74SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int begin = 0, end = matrix.length * matrix[0].length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        _74SearchA2DMatrix solution = new _74SearchA2DMatrix();
        int[][] matrix = new int[][]{{1,3,5,7},
                                     {10,11,16,20},
                                     {23,30,34,50}};
        System.out.println(solution.searchMatrix(matrix, 3));
    }
}
