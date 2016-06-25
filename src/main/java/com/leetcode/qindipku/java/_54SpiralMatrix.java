package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5]. 
 * 
 * @author qindi
 *
 */
public class _54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
List<Integer> list = new ArrayList<Integer>();
        
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        
        int width = matrix[0].length - 1;
        int height = matrix.length - 1;
        int i = 0, j = 0, count = 0;
        int maxCount = Math.min(matrix.length, matrix[0].length);
        
        while (count < maxCount) {
            i = count;
            j = count;
            
            if (count == width - count) {
                for (int k = count; k <= height - count; k++ ) {
                    list.add(matrix[k][count]);
                }
                break;
            } else if (count == height - count) {
                for (int k = count; k <= width - count; k++) {
                    list.add(matrix[count][k]);
                }
                break;
            }
            
            while (j < width - count) {
                list.add(matrix[i][j]);
                j++;
            }
            
            while (i < height - count) {
                list.add(matrix[i][j]);
                i++;
            }
            
            while (j > count) {
                list.add(matrix[i][j]);
                j--;
            }
            
            while (i > count) {
                list.add(matrix[i][j]);
                i--;
            }
            
            count++;
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        _54SpiralMatrix solution = new _54SpiralMatrix();
        System.out.println(solution.spiralOrder(new int[][]{{1}}));
        
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3},
                                                            {4,5,6},
                                                            {7,8,9}}));
        
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3,4},
                                                            {5,6,7,8},
                                                            {9,10,11,12},
                                                            {13,14,15,16}}));

        System.out.println(solution.spiralOrder(new int[][]{{1},
                                                            {2},
                                                            {3},
                                                            {4},
                                                            {5},
                                                            {6},
                                                            {7},
                                                            {8},
                                                            {9},
                                                            {10}}));
        
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}}));

        System.out.println(solution.spiralOrder(new int[][]{{1,2,3,4},
                                                            {11,12,13,14}}));

    }
    
    
}
