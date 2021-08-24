package com.sort.leetcode1353;

import java.util.*;

public class MaxEvents0629 {


    public int maxEvents(int[][] events) {

        int len = events.length;

        Map<Integer, List<Integer>> endMap = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {

            int start = events[i][0];
            min = Math.min(start, min);
            int end = events[i][1];
            max = Math.max(end, max);
            List<Integer> ends = endMap.get(start);
            if (ends == null) {
                ends = new ArrayList<>();
                ends.add(end);
                endMap.put(start, ends);
            } else {
                ends.add(end);
            }
        }


        Queue<Integer> queue = new PriorityQueue<>();

        int ans = 0;

        for (int i = min; i <= max; i++) {

            List<Integer> ends = endMap.get(i);
            if (ends != null) {
                for (Integer end : ends) {
                    queue.offer(end);
                }
            }

            while (!queue.isEmpty() && queue.peek() < i) {
                queue.poll();
            }


            if (!queue.isEmpty() && queue.peek() >= i) {
                queue.poll();
                ans++;
            }

        }

        return ans;

    }
}
