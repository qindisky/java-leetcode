package com.leetcode.qindipku.java;

/**
 *  Given two binary strings, return their sum (also a binary string).
 *  
 *  For example,
 *  a = "11"
 *  b = "1"
 *  Return "100". 
 * 
 * @author qindi
 *
 */
public class _67AddBinary {
    public String addBinary(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        StringBuilder result = new StringBuilder();
        int carry = 0, sum = 0;
        int aIdx = aArr.length - 1, bIdx = bArr.length - 1;
                
        while (aIdx >= 0 && bIdx >= 0) {
            int aNum = aArr[aIdx--] == '0' ? 0 : 1;
            int bNum = bArr[bIdx--] == '0' ? 0 : 1;
            sum = aNum + bNum + carry;
            carry = sum / 2;
            sum = sum % 2;
            result.append(sum);
        }
        
        while (aIdx >= 0) {
            int aNum = aArr[aIdx--] == '0' ? 0 : 1;
            sum = aNum + carry;
            carry = sum / 2;
            sum = sum % 2;
            result.append(sum);
        }
        
        while (bIdx >= 0) {
            int bNum = bArr[bIdx--] == '0' ? 0 : 1;
            sum = bNum + carry;
            carry = sum / 2;
            sum = sum % 2;
            result.append(sum);
        }
        
        if (carry == 1) {
            result.append(carry);
        }
        
        return result.reverse().toString();
    }
    
    
    public static void main(String[] args) {
        _67AddBinary solution = new _67AddBinary();
        System.out.println(solution.addBinary("11", "1"));
    }
}
