package com.bfs.leetcode139;

import junit.framework.TestCase;

import java.util.Arrays;

public class WordBreak0620Test extends TestCase {

    public void testWordBreak() {

        WordBreak0620 wordBreak0620=new WordBreak0620();
        wordBreak0620.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
                , Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
    }
}