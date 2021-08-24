package com.trie.leetcode139;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreak {


    private Trie trie;

    public boolean wordBreak(String s, List<String> wordDict) {

        trie = new Trie();


        for (String word : wordDict) {
            trie.insert(word);
        }

        int len = s.length();


        int index = 0;




        return dfs(s, 0);

    }

    private boolean dfs(String s, int start) {
        if (start == s.length()) {
            return true;
        }

        List<String> query = trie.query(s, start);
        if (query.isEmpty()) {
            return false;
        } else {
            for (String word : query) {
                int next = start + word.length();
                if (next < s.length()) {
                    boolean res = dfs(s, next);
                    if (res) {
                        return true;
                    }
                }

            }

        }

        return false;


    }


    private class Trie {

        private Trie[] children = new Trie[26];

        private boolean isEnd;

        private String word;

        public Trie() {

        }


        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Trie next = cur.children[ch - 'a'];
                if (next == null) {
                    next = new Trie();
                    cur.children[ch - 'a'] = next;
                }
                cur = next;
            }
            cur.isEnd = true;
            cur.word = word;
        }

        public List<String> query(String word, int start) {
            Trie cur = this;
            List<String> res = new ArrayList<>();
            for (int i = start; i < word.length(); i++) {
                char ch = word.charAt(i);
                Trie next = cur.children[ch - 'a'];
                if (next == null) {
                    return res;
                } else if (next.isEnd) {
                    res.add(next.word);
                } else {
                    cur = next;
                }
            }

            return res;

        }

    }
}
