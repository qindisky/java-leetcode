package com.leetcode.qindipku.java;

/**
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *  
 *  For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *  the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * 
 * @author qindi
 *
 */
public class _53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return maxSubArray3(nums);
    }
    
    /**
     * 1、顺序求和比较
     * @param nums
     * @return
     */
    private int maxSubArray1(int[] nums) {
        int ret = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int tmp = 0;
                for (int k = i; k <= j; k++) {
                    tmp += nums[k];
                }
                if (ret < tmp) {
                    ret = tmp;
                }
            }
        }
        
        return ret;
    }
    
    /**
     * 2、分治策略
     * @param nums
     * @return
     */
    private int maxSubArray2(int[] nums) {
        return maxSubArrayDC(nums, 0, nums.length - 1);
    }
    
    private int maxSubArrayDC(int[] nums, int left, int right) {
        int sum = 0;
        if (right == left) {
            return nums[right];
        }
        
        int mid = (left + right) / 2;
        int leftSum = maxSubArrayDC(nums, left, mid);
        int rightSum = maxSubArrayDC(nums, mid + 1, right);
        
        int sl = Integer.MIN_VALUE, tmpSum = 0;
        for (int i = mid; i >= left; i--) {
            tmpSum += nums[i];
            if (tmpSum > sl) {
                sl = tmpSum;
            }
        }
        
        tmpSum = 0;
        int sr = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            tmpSum += nums[i];
            if (tmpSum > sr) {
                sr = tmpSum;
            }
        }
        
        sum = Math.max(rightSum, leftSum);
        sum = Math.max(sum, sl + sr);
        
        return sum;
    }
    
    /**
     * 3、动态规划
     * 
     * @param nums
     * @return
     */
    private int maxSubArray3(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int max = nums[0], sum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            
            if (max < sum) {
                max = sum;
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        _53MaximumSubarray solution = new _53MaximumSubarray();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-2,-1}));
    }
}
