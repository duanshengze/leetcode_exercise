package com.monotonous_stack.leetcode581;

import junit.framework.Assert;
import junit.framework.TestCase;


public class FindUnsortedSubarrayTest extends TestCase {

    public void testFindUnsortedSubarray_01() {

        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        int unsortedSubarray = findUnsortedSubarray.findUnsortedSubarray(new int[]{1, 3, 2, 2, 2});
        Assert.assertEquals(4,unsortedSubarray);
    }
}