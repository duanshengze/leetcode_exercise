package com.union_find.leetcode200;

import junit.framework.TestCase;

public class NumIslandsTest extends TestCase {

    public void testNumIslands() {
        NumIslands numIslands=new NumIslands();
        numIslands.numIslands(new char[][]{{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}});
    }
}