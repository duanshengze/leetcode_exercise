package com.bfs.leetcode127;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength0703 {

    private class Fegment {

        private int level;

        private String word;

        public Fegment(int level, String word) {
            this.level = level;
            this.word = word;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Queue<Fegment> queue = new LinkedList<>();

        queue.offer(new Fegment(0, beginWord));


        while (!queue.isEmpty()) {


            Fegment poll = queue.poll();
            if (endWord.equals(poll.word)) {
                return poll.level + 1;
            }

            Iterator<String> iterator = wordList.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();

                if (check(poll.word, next)) {
                    queue.offer(new Fegment(poll.level + 1, next));
                    iterator.remove();
                }

            }

        }

        return 0;

    }

    private boolean check(String word, String next) {

        int diff = 0;

        int len = word.length();


        int index = 0;
        while (index < len) {

            if (diff >= 2) {
                return false;
            }
            if (word.charAt(index) != next.charAt(index)) {
                diff++;
            }
            index++;
        }

        if (diff == 1) {
            return true;
        }
        return false;
    }
}
