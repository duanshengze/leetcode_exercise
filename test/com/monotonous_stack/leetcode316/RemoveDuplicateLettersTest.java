package com.monotonous_stack.leetcode316;

import junit.framework.TestCase;
import org.junit.Assert;

public class RemoveDuplicateLettersTest extends TestCase {

    public void testRemoveDuplicateLetters_01() {

        RemoveDuplicateLetters remove = new RemoveDuplicateLetters();
        String bcabc = remove.removeDuplicateLetters("bcabc");
        Assert.assertEquals("abc", bcabc);
    }


    public void testRemoveDuplicateLetters_02() {

        RemoveDuplicateLetters remove = new RemoveDuplicateLetters();
        String bcabc = remove.removeDuplicateLetters("cdadabcc");
        Assert.assertEquals("adbc", bcabc);
    }


    public void testRemoveDuplicateLetters_03() {

        RemoveDuplicateLetters remove = new RemoveDuplicateLetters();
        String bcabc = remove.removeDuplicateLetters("bbcaac");
        Assert.assertEquals("bac" , bcabc);
    }


    public void testRemoveDuplicateLetters_04() {

        RemoveDuplicateLetters remove = new RemoveDuplicateLetters();
        String bcabc = remove.removeDuplicateLetters("abacb");
        Assert.assertEquals("abc" , bcabc);
    }

}