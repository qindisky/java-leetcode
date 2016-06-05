package com.leetcode.qindipku.java._29.DivideTwoIntegers;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSolution {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        Solution s = new Solution();
        
        assertEquals("to divide 0 is MAX_VALUE.", Integer.MAX_VALUE, s.divide(10, 0));
        
        assertEquals("10/5=2", 2, s.divide(10, 5));
        
        assertEquals("10/3=3", 3, s.divide(10, 3));
        
        assertEquals("-10/3=-3", -3, s.divide(-10, 3));
        
        assertEquals("2/5=0", 0, s.divide(2, 5));
        
        assertEquals("-1010369383/-2147483648=0", 0, s.divide(-1010369383, -2147483648));
        
        assertEquals("-2147483648/-1=2147483647", 2147483647, s.divide(-2147483648, -1));
        
        assertEquals("-2147483648/1=-2147483648", -2147483648, s.divide(-2147483648, 1));
        
        assertEquals("2147483647/-1=-2147483647", -2147483647, s.divide(2147483647, -1));
        
        assertEquals("-2147483648/2=-1073741824", -1073741824, s.divide(-2147483648, 2));
        
    }

}
