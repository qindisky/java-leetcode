package com.leetcode.qindipku.java;

/**
 * Given an unsorted integer array, find the first missing positive integer. 
 * 
 * For example, 
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author qindi
 *
 */
public class _41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (0 < nums[i] && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
        
        int ret = 1;
        while (ret <= nums.length && ret == nums[ret - 1]) {
            ret++;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        _41FirstMissingPositive solution = new _41FirstMissingPositive();
        System.out.println(solution.firstMissingPositive(new int[]{1,2,0}));

        System.out.println(solution.firstMissingPositive(new int[]{3,4,-1,1}));
        
        System.out.println(solution.firstMissingPositive(new int[]{-1,4,2,1,9,10}));
    }
}
