package com.greedy.leetcode452;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : 1;
            }
        });

        int len = points.length;

        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            int[] before = points[i];
            int[] after = points[i + 1];

            if (after[0] > before[1]) {
                count++;
            } else {
                after[1]=Math.min(before[1],after[1]);
            }

        }

        return count;
    }
}
