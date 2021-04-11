package com.monotonous_stack.leetcode84;

import junit.framework.TestCase;
import org.junit.Assert;

public class LargestRecangleArea_410Test extends TestCase {

    public void testLargestRectangleArea_01_test01() {

        LargestRecangleArea_410 largestRecangleArea_410=new LargestRecangleArea_410();
        int res = largestRecangleArea_410.largestRectangleArea_01(new int[]{2, 1, 5, 6, 2, 3});
        Assert.assertEquals(10,res);
    }


    public void testLargestRectangleArea_01_test02() {

        LargestRecangleArea_410 largestRecangleArea_410=new LargestRecangleArea_410();
        int res = largestRecangleArea_410.largestRectangleArea_01(new int[]{2, 1, 2});
        Assert.assertEquals(3,res);
    }
}