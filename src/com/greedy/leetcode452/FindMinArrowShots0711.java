package com.greedy.leetcode452;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots0711 {

    public int findMinArrowShots(int[][] points) {

        int len = points.length;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        int ans = 1;
        for (int i = 0; i < len - 1; i++) {
            int[] before = points[i];
            int[] after = points[i + 1];

            if (after[0] > before[1]) {
                ans++;
            } else {

                after[1] = Math.min(before[1], after[1]);
            }
        }
        return ans;
    }
}
