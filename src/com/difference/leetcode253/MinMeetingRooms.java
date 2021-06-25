package com.difference.leetcode253;

public class MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
        }

        int[] diff = new int[end - start + 1];

        for (int i = 0; i < len; i++) {
            diff[intervals[i][0] - start] += 1;
            diff[intervals[i][1] - start] -= 1;
        }


        int ans = 0;
        int preSum = 0;
        for (int i = 0; i < diff.length; i++) {
            int cur = preSum + diff[i];
            ans = Math.max(cur, ans);
            preSum = cur;
        }

        return ans;

    }
}
