package com.trie.leetcode208;

import junit.framework.TestCase;

public class TrieTest extends TestCase {

    public void testInsert() {

        Trie trie=new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
    }
}