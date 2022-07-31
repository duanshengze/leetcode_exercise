package com.monotonous_stack.leetcode402;

import junit.framework.Assert;
import junit.framework.TestCase;


public class RemoveKdigitsTest extends TestCase {

    public void testRemoveKdigits_01() {

        RemoveKdigits removeKdigits=new RemoveKdigits();
        String s = removeKdigits.removeKdigits("1432219", 3);
        Assert.assertEquals("1219",s);
    }



    public void testRemoveKdigits_02() {

        RemoveKdigits removeKdigits=new RemoveKdigits();
        String s = removeKdigits.removeKdigits("9", 1);
        Assert.assertEquals("0",s);
    }

    public void testRemoveKdigits_03() {

        RemoveKdigits removeKdigits=new RemoveKdigits();
        String s = removeKdigits.removeKdigits("112", 1);
        Assert.assertEquals("11",s);
    }


    public void testRemoveKdigits_04() {

        RemoveKdigits removeKdigits=new RemoveKdigits();
        String s = removeKdigits.removeKdigits("10", 1);
        Assert.assertEquals("0",s);
    }
}