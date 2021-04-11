package com.monotonous_stack.leetcode84;

import junit.framework.TestCase;
import org.junit.Assert;

public class LargestRectangleArea411Test extends TestCase {

    public void testLargestRectangleArea_01() {
        LargestRectangleArea411 largestRecangleArea411=new LargestRectangleArea411();
        int res = largestRecangleArea411.largestRectangleArea(new int[]{2, 1, 2});
        Assert.assertEquals(3,res);
    }
}