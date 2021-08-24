package com.trie.leetcode208;

public class Trie {


    private Trie[] children = new Trie[26];
    private boolean isEnd = false;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        int len = word.length();

        Trie cur = this;
        for (int i = 0; i < len; i++) {
            Trie node = cur.children[word.charAt(i) - 'a'];
            if (node == null) {
                node = new Trie();
                cur.children[word.charAt(i) - 'a'] = node;
            }
            cur = node;
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int len = word.length();

        Trie cur = this;
        int i = 0;
        for (; i < len; i++) {
            Trie node = cur.children[word.charAt(i) - 'a'];
            if (node == null) {
                break;
            }
            cur = node;
        }

        return cur.isEnd && i == len;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {


        int len = prefix.length();

        Trie cur = this;
        int i = 0;
        for (; i < len; i++) {
            Trie node = cur.children[prefix.charAt(i) - 'a'];
            if (node == null) {
                break;
            }
            cur = node;
        }

        return i == len;
    }

}
