package com.trie.leetocde648;

import java.util.List;

public class ReplaceWords {


    public String replaceWords(List<String> dictionary, String sentence) {


        Tries tries = new Tries();

        for (String dic : dictionary) {
            tries.insert(dic);
        }


        String[] words = sentence.split(" ");

        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String s = tries.get(word);
            if (s != null) {
                strB.append(s);
            } else {
                strB.append(word);
            }

            if (i < words.length - 1) {
                strB.append(" ");
            }
        }
        return strB.toString();
    }


    private class Tries {
        private Tries[] children = new Tries[26];
        private boolean isEnd;

        private String word;

        public Tries() {
        }

        public void insert(String word) {
            Tries cur = this;

            for (int i = 0; i < word.length(); i++) {

                char c = word.charAt(i);

                Tries node = cur.children[c - 'a'];

                if (node == null) {
                    node = new Tries();
                    cur.children[c - 'a'] = node;
                }
                cur = node;
            }

            cur.word = word;
        }


        public String get(String word) {
            Tries cur = this;

            for (int i = 0; i < word.length(); i++) {

                char c = word.charAt(i);
                Tries node = cur.children[c - 'a'];

                if (node == null) {
                    break;
                }

                if (node != null && node.word != null) {
                    return node.word;
                }
                cur = node;
            }

            return cur.word;
        }

    }
}
