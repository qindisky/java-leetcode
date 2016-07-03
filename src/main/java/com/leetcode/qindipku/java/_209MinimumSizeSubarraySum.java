package com.leetcode.qindipku.java;

/**
 *  Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. 
 *  If there isn't one, return 0 instead.
 *  
 *  For example, given the array [2,3,1,2,4,3] and s = 7,
 *  the subarray [4,3] has the minimal length under the problem constraint.
 *  
 * @author qindi
 *
 */
public class _209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, begin = 0, end = 0;
        int minSubLength = Integer.MAX_VALUE;
        
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                if (minSubLength > end - begin + 1) {
                    minSubLength = end - begin + 1;
                }
                sum -= nums[begin];
                begin++;
            }
        }
        
        if (minSubLength == Integer.MAX_VALUE) {
            minSubLength = 0;
        }
        
        return minSubLength;
    }
    
    public static void main(String[] args) {
        _209MinimumSizeSubarraySum solution = new _209MinimumSizeSubarraySum();
        System.out.println(solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
