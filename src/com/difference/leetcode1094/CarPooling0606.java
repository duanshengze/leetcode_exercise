package com.difference.leetcode1094;

public class CarPooling0606 {

    public boolean carPooling(int[][] trips, int capacity) {
        int len = trips.length;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;


        for (int i = 0; i < len; i++) {
            start = Math.min(trips[i][1], start);
            end = Math.max(trips[i][2], end);
        }

        int[] diff = new int[end - start + 1];


        for (int i = 0; i < len; i++) {
            diff[trips[i][1] - start] += trips[i][0];
            diff[trips[i][2] - start] -= trips[i][0];
        }

        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (sum > capacity) {
                return false;
            }
        }

        return true;


    }
}
