package com.leetcode.qindipku.java._40CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  Given a collection of candidate numbers (C) and a target number (T), 
 *  find all unique combinations in C where the candidate numbers sums to T.
 *  
 *  Each number in C may only be used once in the combination.
 *  
 *  Note:
 *  
 *  All numbers (including target) will be positive integers.
 *  The solution set must not contain duplicate combinations.
 *  
 *  For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 *  A solution set is:
 *  
 *  [
 *      [1, 7],
 *      [1, 2, 5],
 *      [2, 6],
 *      [1, 1, 6]
 *  ]
 *  
 * @author qindi
 *
 */
public class _40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return result;
     
        Arrays.sort(candidates);
     
        List<Integer> temp = new ArrayList<Integer>();    
        getCombination(candidates, 0, target, temp, result);
     
        Set<List<Integer>> set = new HashSet<List<Integer>>(result);
     
        //remove duplicate lists
        result.clear();
        result.addAll(set);
     
        return result;
    }
     
    public void getCombination(int[] num, int start, int target, List<Integer> temp, List<List<Integer>> result){
        if(target == 0){
            ArrayList<Integer> t = new ArrayList<Integer>(temp);
            result.add(t);
            return;
        }
     
        for(int i=start; i<num.length; i++){
            if(target < num[i])
                continue;
     
            temp.add(num[i]);
            getCombination(num, i+1, target-num[i], temp, result);
            temp.remove(temp.size()-1);
        }
    }
    
    public static void main(String[] args) {
        _40CombinationSumII solution = new _40CombinationSumII();
        //_40CombinationSumII2 solution = new _40CombinationSumII2();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}

class _40CombinationSumII2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Map<Integer, Integer> candidateMap = new  HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int candidate : candidates) {
            if (candidateMap.containsKey(candidate)) {
                candidateMap.put(candidate, candidateMap.get(candidate) + 1);
            } else {
                list.add(candidate);
                candidateMap.put(candidate, 1);
            }
        }
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> tmpResult = new ArrayList<Integer>();
        
        beBack(list, candidateMap, target, 0, ret, tmpResult);
        
        return ret;
    }
    
    private void beBack(List<Integer> list, Map<Integer, Integer> map, int target, int k, List<List<Integer>> store, List<Integer> result) {
        System.out.println("target:" + target + "\tk:" + k + "\tresult:" + result);
        if (0 == target) {
            List<Integer> ret = new ArrayList<Integer>(result);
            store.add(ret);
        } else if (target > 0 && k < list.size()) {
            int curVal = list.get(k);
            for (int i = 0; i <= map.get(curVal); i++) {
                int curCount = i;
                int curTarget = target;
                
                while (curCount-- > 0) {
                    result.add(curVal);
                    curTarget -= curVal;
                }
                if (curTarget >= 0) {
                    beBack(list, map, curTarget, k + 1, store, result);
                }
                
                curCount = i;
                while (curCount-- > 0) {
                    result.remove(result.size() - 1);
                }
            }
        }
    }
}