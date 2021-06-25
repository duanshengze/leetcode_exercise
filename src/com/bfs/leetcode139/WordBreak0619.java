package com.bfs.leetcode139;

import java.util.*;

public class WordBreak0619 {


    public boolean wordBreak(String s, List<String> wordDict) {
        int sLen = s.length();
        int len = wordDict.size();
        Map<Character, List<Integer>> headMap = new HashMap<>();
        for (int i = 0; i < len; i++) {

            String word = wordDict.get(i);
            char head = word.charAt(0);
            List<Integer> list = headMap.get(head);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                headMap.put(head, list);
            } else {
                list.add(i);
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[sLen];
        List<Integer> heads = headMap.get(s.charAt(0));
        if (heads != null) {
            for (Integer head : heads) {
                String word = wordDict.get(head);
                int curEnd = word.length() - 1;
                if (check(s, word, 0, curEnd) && !vis[curEnd]) {

                    queue.offer(word.length() - 1);
                    vis[curEnd] = true;
                }

            }
        }


        while (!queue.isEmpty()) {
            int preEnd = queue.poll();
            if (preEnd == sLen - 1) {
                return true;
            }
            int nextStart = preEnd + 1;
            if (nextStart >= s.length()) {
                return false;
            }

            List<Integer> headList = headMap.get(s.charAt(nextStart));

            if (headList == null) {
                continue;
            }
            for (Integer head : headList) {
                String word = wordDict.get(head);
                int curEnd = nextStart + word.length() - 1;
                if (check(s, word, nextStart, curEnd) && !vis[curEnd]) {
                    queue.offer(curEnd);
                    vis[curEnd] = true;
                }

            }

        }

        return false;
    }


    private boolean check(String s, String word, int start, int end) {

        if (end >= s.length()) {
            return false;
        }
        int index = start;
        int wordIndex = 0;
        while (index <= end) {
            if (s.charAt(index++) != word.charAt(wordIndex++)) {
                return false;
            }
        }

        return true;


    }
}
