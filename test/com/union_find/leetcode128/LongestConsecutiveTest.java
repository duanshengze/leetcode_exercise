package com.union_find.leetcode128;

import junit.framework.TestCase;
import org.junit.Assert;

public class LongestConsecutiveTest extends TestCase {

    public void testLongestConsecutive() {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int i = longestConsecutive.longestConsecutive(new int[]{-3, 2, 8, 5, 1, 7, -8, 2, -8, -4, -1, 6, -6, 9, 6, 0, -7, 4, 5, -4, 8, 2, 0, -2, -6, 9, -4, -1});
        Assert.assertEquals(7,i);

    }
}