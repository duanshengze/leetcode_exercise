package com.slide_window.leetcode239;

import junit.framework.TestCase;
import org.junit.Assert;

public class MaxSlidingWindow0523Test extends TestCase {

    public void testMaxSlidingWindow() {
        MaxSlidingWindow0523 maxSlidingWindow0523=new MaxSlidingWindow0523();
        int[] ints = maxSlidingWindow0523.maxSlidingWindow(new int[]{1, -1}, 1);
        Assert.assertArrayEquals(ints,new int[]{1,-1});
    }
}