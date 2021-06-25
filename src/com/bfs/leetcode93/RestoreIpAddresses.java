package com.bfs.leetcode93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RestoreIpAddresses {


    private class Segment {

        private int currValue;
        private int end;
        private StringBuilder curStr;
        private int layer;

        public Segment(int currValue, int end, StringBuilder curStr, int layer) {
            this.currValue = currValue;
            this.end = end;
            this.curStr = curStr;
            this.layer = layer;
        }
    }


    public List<String> restoreIpAddresses(String s) {

        int slen = s.length();

        Queue<Segment> queue = new LinkedList<>();

        int start = 0;

        for (int len = 1; len <= 3; len++) {
            int end = start + len - 1;
            if (end >= slen) {
                continue;
            }

            if (len >= 2 && s.charAt(start) == '0') {
                continue;
            }
            int res = transInt(s, start, end);
            if (res <= 255 && res >= 0) {
                queue.offer(new Segment(res, end, new StringBuilder().append(res), 1));
            }
        }


        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Segment segment = queue.poll();

            if (segment.end == slen - 1 && segment.layer == 4) {
                ans.add(segment.curStr.toString());
            }

            if (segment.end < slen - 1 && segment.layer < 4) {
                int sStart = segment.end + 1;
                for (int len = 1; len <= 3; len++) {
                    int sEnd = sStart + len - 1;
                    if (sEnd >= slen) {
                        continue;
                    }

                    if (len >= 2 && s.charAt(sStart) == '0') {
                        continue;
                    }
                    int res = transInt(s, sStart, sEnd);

                    if (res <= 255 && res >= 0) {

                        queue.offer(new Segment(res, sEnd, new StringBuilder(segment.curStr).append(".").append(res), segment.layer + 1));
                    }
                }


            }


        }

        return ans;

    }

    private int transInt(String s, int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res;
    }
}
