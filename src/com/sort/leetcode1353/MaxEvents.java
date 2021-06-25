package com.sort.leetcode1353;

import java.util.*;

public class MaxEvents {

    public int maxEvents(int[][] events) {
        int len = events.length;

        Map<Integer, List<Integer>> endMap = new HashMap<>();

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {

            int start = events[i][0];
            minDay = Math.min(minDay, start);
            int end = events[i][1];
            maxDay = Math.max(maxDay, end);

            List<Integer> list = endMap.get(start);
            if (list == null) {
                list = new ArrayList<>();
                list.add(end);
                endMap.put(start, list);
            } else {
                list.add(end);
            }
        }

        int ans = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = minDay; i <= maxDay; i++) {

            List<Integer> list = endMap.get(i);
            if (list != null) {

                for (Integer end : list) {
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
