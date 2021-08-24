package com.trie.leetcode820;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumLengthEncoding {


    public int minimumLengthEncoding(String[] words) {

        Trie trie = new Trie();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        int ans = 0;
        for (String word : words) {
            ans += trie.insert(word);
        }

        return ans;
    }


    private class Trie {
        private Trie[] children = new Trie[26];


        public int insert(String word) {

            Trie cur = this;
            int len = word.length();
            boolean isNew = false;
            for (int i = len - 1; i >= 0; i--) {
                Trie node = cur.children[word.charAt(i) - 'a'];
                if (node == null) {
                    isNew = true;
                    node = new Trie();
                    cur.children[word.charAt(i) - 'a'] = node;
                }
                cur = node;
            }

            if (isNew) {
                return word.length() + 1;
            }
            return 0;

        }

    }
}
