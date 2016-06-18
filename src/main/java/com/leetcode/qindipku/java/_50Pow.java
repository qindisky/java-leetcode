package com.leetcode.qindipku.java;

/**
 * Implement pow(x, n). 
 * 
 * @author qindi
 *
 */
public class _50Pow {
    
    public double myPow(double x, int n) {
        return myPow2(x, n);
    }
    
    public double myPow1(double x, int n) {
        if (x == 0) {
            return 0;
        }
        
        double ret = 1.0;
        
        while (n != 0) {
            if (n > 0) {
                ret *= x;
                n--;
            } else {
                ret /= x;
                n++;
            }
        }
        
        return ret;
    }
    
    public double myPow2(double x, int n) {
        boolean sign = false;
        long exp = (long)n;
        if(n<0){
            exp = -(long)n;
            sign = true;
        }
        
        double result = 1.0;
        while (exp > 0) {
            if (exp % 2 == 1){
                result *= x;
            }
            exp >>= 1;
            x *= x;
        }
        
        return sign ? 1.0/result : result;
    }
    
    public static void main(String[] args) {
        _50Pow solution = new _50Pow();
        double x = 2.0;
        System.out.println(solution.myPow(x, 0));
        System.out.println(solution.myPow(x, 1));
        System.out.println(solution.myPow(x, 2));
        System.out.println(solution.myPow(x, -1));
        System.out.println(solution.myPow(x, -2));
        
        System.out.println(solution.myPow(2.00000, -2147483648));
        
        System.out.println(Math.pow(0.0, 0));
        System.out.println(Integer.MIN_VALUE + "\t" + Integer.MAX_VALUE);
    }
}
