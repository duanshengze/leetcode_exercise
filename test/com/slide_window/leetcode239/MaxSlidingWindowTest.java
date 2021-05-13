package com.slide_window.leetcode239;

import junit.framework.TestCase;

public class MaxSlidingWindowTest extends TestCase {

    public void testMaxSlidingWindow() {

        MaxSlidingWindow maxSlidingWindow=new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}