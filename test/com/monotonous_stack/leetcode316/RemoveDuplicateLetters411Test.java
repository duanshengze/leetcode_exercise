package com.monotonous_stack.leetcode316;

import junit.framework.TestCase;
import org.junit.Assert;

public class RemoveDuplicateLetters411Test extends TestCase {



    public void testRemoveDuplicateLetters_01() {

        RemoveDuplicateLetters411 remove = new RemoveDuplicateLetters411();
        String bcabc = remove.removeDuplicateLetters("bcabc");
        Assert.assertEquals("abc", bcabc);
    }


    public void testRemoveDuplicateLetters_02() {

        RemoveDuplicateLetters411 remove = new RemoveDuplicateLetters411();
        String bcabc = remove.removeDuplicateLetters("cdadabcc");
        Assert.assertEquals("adbc", bcabc);
    }


    public void testRemoveDuplicateLetters_03() {

        RemoveDuplicateLetters411 remove = new RemoveDuplicateLetters411();
        String bcabc = remove.removeDuplicateLetters("bbcaac");
        Assert.assertEquals("bac" , bcabc);
    }


}