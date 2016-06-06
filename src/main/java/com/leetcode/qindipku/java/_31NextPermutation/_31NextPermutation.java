package com.leetcode.qindipku.java._31NextPermutation;

/**
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *  If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *  The replacement must be in-place, do not allocate extra memory.
 *  Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *  1,2,3 → 1,3,2
 *  3,2,1 → 1,2,3
 *  1,1,5 → 1,5,1
 *  1,1,5,5 -> 1,5,5,1 -> 1,5,1,5
 *  1,1,5,5,4,3,2,1 -> 1,2,5,5,4,3,1,1 -> 1,2,1,1,3,4,5,5
 *  Subscribe to see which companies asked this question
 * @author qindi
 *
 */
public class _31NextPermutation {

    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        
        int left = nums.length - 1, right = left;
        
        while (left > 0 && nums[left - 1] >= nums[left]) {
            left--;
        }
        
        if (0 == left) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        left--;
        while (right > left && nums[left] >= nums[right]) {
            right--;
        }
        
        swap(nums, left, right);
        
        reverse(nums, left + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }
    
    public void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        _31NextPermutation s = new _31NextPermutation();
        int[] nums = new int[]{1,1,5,5,4,3,2,1};
        s.nextPermutation(nums);
        s.print(nums);
        
    }
}
