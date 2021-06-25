package com.bfs.leetcode139;

import java.util.*;

public class WordBreak0620 {

    public boolean wordBreak(String s, List<String> wordDict) {

        int sLen = s.length();
        Map<Character, Set<String>> map = new HashMap<>();
        Map<String, Integer> endMap = new HashMap<>();
        for (String word : wordDict) {
            char head = word.charAt(0);
            Set<String> words = map.get(head);
            if (words == null) {
                words = new HashSet<>();
                words.add(word);
                map.put(head, words);
            } else {
                words.add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        char ch = s.charAt(0);
        if (map.get(ch) != null) {
            for (String word : map.get(ch)) {
                if (check(s, word, 0)) {
                    queue.offer(word);
                    endMap.put(word, word.length() - 1);
                }
            }
        }

        while (!queue.isEmpty()) {

            String word = queue.poll();
            Integer end = endMap.get(word);
            if (end == s.length() - 1) {
                return true;
            }

            int start = end + 1;
            if (start >= s.length()) {
                return false;
            }
            char startCh = s.charAt(start);
            if (map.get(startCh) != null) {
                for (String startWord : map.get(startCh)) {
                    if (check(s, startWord, start)) {
                        queue.offer(startWord);
                        endMap.put(startWord, start + startWord.length() - 1);
                    }
                }
            }

        }

        return false;
    }

    private boolean check(String s, String word, int start) {

        int end = start + word.length() - 1;
        if (end >= s.length()) {
            return false;
        }

        int sIndex = start;
        int wordIndex = 0;
        while (sIndex <= end) {
            if (s.charAt(sIndex++) != word.charAt(wordIndex++)) {
                return false;
            }
        }

        return true;

    }
}
