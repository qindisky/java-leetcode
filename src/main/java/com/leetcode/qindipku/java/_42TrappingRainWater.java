package com.leetcode.qindipku.java;

/**
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 *  compute how much water it is able to trap after raining.
 *  
 *  For example,
 *  
 *  Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 * 
 * @author qindi
 *
 */
public class _42TrappingRainWater {
    public int trap(int[] height) {
        if (null == height || height.length <= 2) {
            return 0;
        }
        
        int maxHeight = 0, maxIdx = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIdx = i;
            }
        }

        int preHeight = 0, sum = 0;
        
        //from left to maxIdx
        for (int i = 0; i < maxIdx; i++ ) {
            if (height[i] > preHeight) {
                preHeight = height[i];
            }
            sum += preHeight - height[i];
            System.out.println(preHeight + "\t" + height[i] + "\t" + sum);
        }
        
        //from right to maxIdx
        preHeight = 0;
        for (int i = height.length - 1; i > maxIdx; i--) {
            if (height[i] > preHeight) {
                preHeight = height[i];
            }
            sum += preHeight - height[i];
            System.out.println(sum);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        _42TrappingRainWater solution = new _42TrappingRainWater();
        
        System.out.println(solution.trap(new int[]{4,2,0,3,2,5}));
    }
}
