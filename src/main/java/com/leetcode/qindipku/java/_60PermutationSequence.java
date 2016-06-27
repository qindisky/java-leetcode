package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author qindi
 *
 */
public class _60PermutationSequence {
    
    public String getPermutation(int n, int k) {
        List<Integer> numberList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }

        k--;

        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }

        StringBuilder result = new StringBuilder();
        
        for (int i = n; i > 0; i--) {
            mod = mod / i;
            int curIdx = k / mod;
            k = k % mod;
            
            result.append(numberList.get(curIdx));
            numberList.remove(curIdx);
        }

        return result.toString();
    }
    
    public static void main(String[] args) {
        _60PermutationSequence solution = new _60PermutationSequence();
        System.out.println(solution.getPermutation(3, 5));
    }
}
