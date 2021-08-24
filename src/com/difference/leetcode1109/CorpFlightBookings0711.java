package com.difference.leetcode1109;

public class CorpFlightBookings0711 {


    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] diff = new int[n + 2];

        int len = bookings.length;

        for (int i = 0; i < len; i++) {

            diff[bookings[i][0]] += bookings[i][2];
            diff[bookings[i][1] + 1] -= bookings[i][2];
        }

        int preSum = 0;
        int[] a = new int[n];
        for (int i = 1; i <= n; i++) {
            int cur = preSum + diff[i];
            a[i - 1] = cur;
            preSum = cur;
        }
        return a;
    }
}
