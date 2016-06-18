package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a collection of distinct numbers, return all possible permutations.
 *  For example,
 *  [1,2,3] have the following permutations:
 * 
 * @author qindi
 *
 */
public class _46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> store = new ArrayList<List<Integer>>();
        reback(store, nums, 0);
        return store;
    }
    
    private void reback(List<List<Integer>> store, int[] nums, int j) {
        if (j == nums.length - 1) {
            List<Integer> result = new ArrayList<Integer>(nums.length);
            for (int num : nums) {
                result.add(num);
            }
            store.add(result);
        } else {
            for (int i = j; i < nums.length; i++) {
                swap(nums, i, j);
                reback(store, nums, j + 1);
                swap(nums, i, j);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        _46Permutations solution = new _46Permutations();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }
}
