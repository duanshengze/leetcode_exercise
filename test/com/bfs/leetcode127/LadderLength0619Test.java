package com.bfs.leetcode127;

import junit.framework.TestCase;

import java.util.Arrays;

public class LadderLength0619Test extends TestCase {

    public void testLadderLength() {
        LadderLength0619 ladderLength0619 = new LadderLength0619();
        ladderLength0619.ladderLength("hit","cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
    }
}