package com.leetcode.qindipku.java;

/**
 * 
 * 70. Climbing Stairs
 * 
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 * 
 * @author qindi
 *
 */
public class _70ClimbingStairs {
    public int climbStairs(int n) {
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = 1;
            } else if (i == 1) {
                arr[i] = 2;
            } else {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
        }
        
        return arr[n - 1];
    }
    
    public static void main(String[] args) {
        _70ClimbingStairs solution = new _70ClimbingStairs();
        System.out.println(solution.climbStairs(3));
    }
}
