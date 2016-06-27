package com.leetcode.qindipku.java;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author qindi
 *
 */
public class _66PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length <= 0) {
            return new int[]{1};
        }
        
        int i = digits.length - 1;
        digits[i] += 1;
        int carray = digits[i] / 10;
        digits[i] = digits[i] % 10;
        
        for (i--; i >= 0; i--) {
            digits[i] += carray;
            carray = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        
        if (carray == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = carray;
            for (int j = 0; j < digits.length; j++) {
                result[j + 1] = digits[j];
            }
            return result;
        }
    }
    
    public void printArr(int[] arr) {
        for(int n : arr) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        _66PlusOne solution = new _66PlusOne();
        solution.printArr(solution.plusOne(new int[]{9,9}));

        solution.printArr(solution.plusOne(new int[]{9,8}));
    }
}
