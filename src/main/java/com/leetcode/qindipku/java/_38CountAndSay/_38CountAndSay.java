package com.leetcode.qindipku.java._38CountAndSay;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string. 
 * 
 * (Easy)
 * 
 * @author qindi
 *
 */
public class _38CountAndSay {
    public String countAndSay(int n) {
        String tmp = "1";
        while (--n > 0) {
            tmp = say(tmp);
        }
        
        return tmp;
    }
    
    private String say(String n) {
        StringBuilder sb = new StringBuilder();
        char[] arr = n.toCharArray();
        char pre = arr[0], cur; 
        int count = 1;
        
        for (int i = 1; i < arr.length; i++) {
            cur = arr[i];
            
            if (cur == pre) {
                count++;
            } else {
                sb.append(count).append(pre);
                pre = cur;
                count = 1;
            }
        }

        sb.append(count).append(pre);

        return sb.toString();
    }
    
    //数据范围溢出，不能用数据运算
    private long sayIn9(long n) {
        long ret = 0, product = 1;
        long pre = n % 10, num, count = 0;

        while (n > 0) {
            num = n % 10;
            n = n / 10;
            
            if (num == pre) {
                count++;
            } else {
                ret = (count * 10 + pre) * product + ret;
                product *= 100;
                pre = num;
                count = 1;
            }
        }
        
        ret = (count * 10 + pre) * product + ret;
        
        return ret;
    }
    
    
    
    
    public static void main(String[] args) {
        
        _38CountAndSay solution = new _38CountAndSay();
        for (int i = 1; i <= 19; i++) {
            System.out.println(i + "\t" + solution.countAndSay(i));
        }

    }
}
