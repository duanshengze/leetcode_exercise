package com.bfs.leetcode127;

import java.util.*;

public class LadderLength0619 {


    private class Segment {
        private String word;
        private int level;



        public Segment(String word, int level) {
            this.word = word;
            this.level = level;


        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            wordSet.add(wordList.get(i));
        }


        Queue<Segment> queue = new LinkedList<>();
        queue.offer(new Segment(beginWord, 1));

        while (!queue.isEmpty()) {
            Segment poll = queue.poll();
            if (poll.word.equals(endWord)) {
                return poll.level;
            } else {
                Iterator<String> iterator = wordSet.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    if ( check(word, poll.word)) {
                        Segment segment = new Segment(word, poll.level + 1);
                        queue.offer(segment);
                        iterator.remove();

                    }
                }
            }

        }

        return 0;

    }

    private boolean check(String word1, String word2) {

        if (word1.length() == 1) {

            if (word1.charAt(0) != word2.charAt(0)) {
                return true;
            } else {
                return false;
            }
        }

        int diff = 0;

        for (int i = 0; i < word1.length(); i++) {

            if (diff > 2) {
                return false;
            }
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;

    }

}
