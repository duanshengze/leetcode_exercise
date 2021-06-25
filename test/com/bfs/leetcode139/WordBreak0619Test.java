package com.bfs.leetcode139;

import junit.framework.TestCase;

import java.util.Arrays;

public class WordBreak0619Test extends TestCase {

    public void testWordBreak() {

        WordBreak0619 wordBreak0619=new WordBreak0619();
        wordBreak0619.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
              , Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
    }
}