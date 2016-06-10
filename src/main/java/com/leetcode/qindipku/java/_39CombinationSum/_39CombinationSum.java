package com.leetcode.qindipku.java._39CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a set of candidate numbers (C) and a target number (T), 
 *  find all unique combinations in C where the candidate numbers sums to T.
 *  
 *  The same repeated number may be chosen from C unlimited number of times.
 *  
 *  Note:
 *  
 *  All numbers (including target) will be positive integers.
 *  The solution set must not contain duplicate combinations.
 *  
 *  For example, given candidate set [2, 3, 6, 7] and target 7,
 *  A solution set is:
 *  
 *  [
 *  [7],
 *  [2, 2, 3]
 *  ]
 *  
 * @author qindi
 *
 */
public class _39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> store = new ArrayList<List<Integer>>();
        int[] tmpResult = new int[candidates.length];
        
        reBack(candidates, target, 0, store, tmpResult);
        
        return store;
    }
    
    private void reBack(int[] candidates, int target, int k, List<List<Integer>> store, int[] tmpResult) {
        /*System.out.print(target + ":\t" + k + "\t");
        for (int i = 0; i < k; i++) {
            System.out.print(candidates[i] + "*" + tmpResult[i] + "+");
        }
        System.out.println();*/
        
        if (0 == target) {
            List<Integer> oneResult = new ArrayList<Integer>();
            for (int i = 0; i < k; i++) {
                int count = tmpResult[i];
                
                while (count-- > 0) {
                    oneResult.add(candidates[i]);
                }
            }
            store.add(oneResult);
            
            return;
        } else if (target > 0 && k < candidates.length){
            for (int i = 0; i <= target / candidates[k]; i++) {
                tmpResult[k] = i;
                
                reBack(candidates, target - candidates[k] * tmpResult[k], k + 1, store, tmpResult);
            }
        }
    }
    
    public static void main(String[] args) {
        _39CombinationSum solution = new _39CombinationSum();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
