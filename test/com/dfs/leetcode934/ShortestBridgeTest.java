package com.dfs.leetcode934;

import junit.framework.TestCase;

public class ShortestBridgeTest extends TestCase {

    public void testShortestBridge() {
        ShortestBridge shortestBridge = new ShortestBridge();
        shortestBridge.shortestBridge(new int[][]{{0, 1,0}, {0, 0,0},{0,0,1}});
    }
}