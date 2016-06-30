package com.leetcode.qindipku.java;

/**
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 *  with the colors in the order red, white and blue.
 *  
 *  Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. 
 * 
 * @author qindi
 *
 */
public class _75SortColors {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int n : nums) {
            colors[n]++;
        }
        
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            while (colors[i]-- > 0) {
                nums[idx++] = i;
            }
        }
    }
    
    public static void main (String[] args) {
        _75SortColors solution = new _75SortColors();
        int[] nums = new int[]{0,1,0,2,2,1,0,2,1,0};
        solution.sortColors(nums);
        for (int n : nums) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
}
