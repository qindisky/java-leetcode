package com.leetcode.qindipku.java._29.DivideTwoIntegers;

/**
 *  Divide two integers without using multiplication, division and mod operator.
 *  If it is overflow, return MAX_INT. 
 * @author qindi
 *
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) ? -1 : 1;
        
        long lDividend = (long)dividend, lDivisor = (long)divisor;
        lDividend = lDividend > 0 ? lDividend : -lDividend;
        lDivisor = lDivisor > 0 ? lDivisor : -lDivisor;
        long arr[] = new long[33];
        int i = 0;
        arr[i] = lDivisor;
        
        while (arr[i] <= lDividend) {
            arr[++i] = arr[i-1] + arr[i-1];
        }
        i--;
        
        long ret = 0;
        while (lDividend >= lDivisor) {
            if (lDividend >= arr[i]) {
                lDividend -= arr[i];
                ret += (1 << i);
            } else {
                i--;
            }
        }
        
        if ( ret > Integer.MAX_VALUE && sign > 0) {
            return Integer.MAX_VALUE;
        }
        
        return (int)ret * sign;
    }
    
    public int divide2(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        long lDividend = (long)dividend, lDivisor = (long)divisor;
        lDividend = lDividend > 0 ? lDividend : -lDividend;
        lDivisor = lDivisor > 0 ? lDivisor : -lDivisor;
        
        int ret = 0;
        while (lDividend >= lDivisor) {
            int numShift = 0;
            while (lDividend >= (lDivisor << numShift)) {
                numShift++;
            }
            
            ret += 1 << (numShift - 1);
            lDividend -= (lDivisor << (numShift - 1));
        }
        
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            return ret;
        }else{
            return -ret;
        }
    }
    
    public int divide1(int dividend, int divisor) {
        if (0 == divisor) {
            return Integer.MAX_VALUE;
        }
        
        int ret = 0, tmp = 0, flag = 1;
        
        if (dividend < 0) {
            dividend = -dividend;
            flag = -flag;
        }
        if (divisor < 0) {
            divisor = -divisor;
            flag = -flag;
        }
        
        if (1 == divisor) {
            ret = dividend;
        } else {
            while (dividend - tmp >= divisor) {
                tmp += divisor;
                ret++;
            }
        }
        
        if (flag == -1) {
            ret = -ret;
        }
        
        return ret;
    }
}
