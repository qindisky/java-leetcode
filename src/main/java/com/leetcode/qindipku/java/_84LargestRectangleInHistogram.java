package com.leetcode.qindipku.java;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram. 
 * 
 * @author qindi
 *
 */
public class _84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int i = 0, max = 0;

        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int idx = stack.pop();
                max = Math.max(max, heights[idx] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            max = Math.max(max, heights[idx] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        }

        return max;
    }
    
    public static void main(String[] args) {
        _84LargestRectangleInHistogram solution = new _84LargestRectangleInHistogram();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
