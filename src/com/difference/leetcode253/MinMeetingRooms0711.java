package com.difference.leetcode253;

public class MinMeetingRooms0711 {

    public int minMeetingRooms(int[][] intervals) {

        int len = intervals.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][0]);
        }

        int[] diff = new int[max + 1];

        for (int i = 0; i < len; i++) {
            diff[intervals[i][0]] += 1;
            diff[intervals[i][1]] -= 1;
        }

        int ans = 0;
        int pre = 0;
        for (int i = min; i <= max; i++) {
            int cur = pre + diff[i];
            ans = Math.max(ans, cur);
            pre = cur;
        }
        return ans;

    }
}
