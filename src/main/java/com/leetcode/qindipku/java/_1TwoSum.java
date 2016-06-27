package com.leetcode.qindipku.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author qindi
 *
 */
public class _1TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[]{-1, -1};

        for (int i = 0; i < numbers.length; i++) {
            int rest = target - numbers[i];
            if (map.containsKey(rest)) {
                result[0] = map.get(rest);
                result[1] = i;
                break;
            } else {
                map.put(numbers[i], i);
            }
        }

        return result;
    }
}
