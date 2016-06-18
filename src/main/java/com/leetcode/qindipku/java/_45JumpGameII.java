package com.leetcode.qindipku.java;

/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *  Each element in the array represents your maximum jump length at that position.
 *  Your goal is to reach the last index in the minimum number of jumps.
 *  
 *  For example:
 *  Given array A = [2,3,1,1,4]
 *  The minimum number of jumps to reach the last index is 2. 
 *  (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *  Note:
 *  You can assume that you can always reach the last index.
 * 
 * @author qindi
 *
 */
public class _45JumpGameII {
    //A = [2,3,1,1,4], return true. 
    //A = [3,2,1,0,4], return false. 
    //2,5,0,0 true
    public boolean canJump(int[] nums) {
        if (nums.length <= 0) {
            return false;
        }
        
        int endIdx = nums.length - 1;
        
        int coverPos = 0;
        for (int i = 0; i <= coverPos && i <= endIdx; i++) {
            int curCoverPos = i + nums[i];
            if (coverPos < curCoverPos) {
                coverPos = curCoverPos;
            }
            
            if (coverPos >= endIdx) {
                return true;
            }
        }
        
        return false;
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        int steps = 0, coverPos = 0;
        
        for (int i = 0; i <= coverPos && i < nums.length;) {
            if (nums[i] == 0 ) {
                return -1;
            }
            
            if (coverPos < nums[i] + i) {
                steps++;
                coverPos = nums[i] + i;
            }
            
            if (coverPos >= nums.length - 1) {
                return steps;
            }
            
            int nextPos = 0, maxDistance = 0;
            for (int j = i + 1; j<= coverPos; j++) {
                if (maxDistance < j + nums[j]) {
                    nextPos = j;
                    maxDistance = j + nums[j];
                }
            }
            i = nextPos;
        }
        
        return steps;
    }
    
    private void cal(int[] nums, int[] min, int i, int count) {
        if (count >= min[0]) {
            return;
        }
        System.out.println(i + "\t" + nums[i] + "\t" + count + "\t" + min[0]);
        for (int step = nums[i]; step >= 1; step--) {
            if (i + step == nums.length - 1) {
                System.out.println(count + 1);
                if (min[0] > count + 1) {
                    min[0] = count + 1;
                }
            } else if (i + step < nums.length - 1) {
                cal(nums, min, i + step, count + 1);
            } else {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        _45JumpGameII solution = new _45JumpGameII();
        System.out.println(solution.jump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}));
       
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
        System.out.println(solution.canJump(new int[]{2,5,0,0}));
        System.out.println(solution.canJump(new int[]{2,2,0,2,0,2,0,0,2,0}));
    }
}
