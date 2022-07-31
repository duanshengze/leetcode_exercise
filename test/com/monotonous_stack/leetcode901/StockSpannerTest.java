package com.monotonous_stack.leetcode901;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StockSpannerTest extends TestCase {

    public void testNext() {

        StockSpanner stockSpanner=new StockSpanner();

        int next = stockSpanner.next(100);
        Assert.assertEquals(1,next);
        next = stockSpanner.next(80);

        Assert.assertEquals(1,next);

        next = stockSpanner.next(60);

        Assert.assertEquals(1,next);

        next = stockSpanner.next(70);

        Assert.assertEquals(2,next);


        next = stockSpanner.next(60);

        Assert.assertEquals(1,next);


        next = stockSpanner.next(75);

        Assert.assertEquals(4,next);


        next = stockSpanner.next(85);

        Assert.assertEquals(6,next);

    }
}