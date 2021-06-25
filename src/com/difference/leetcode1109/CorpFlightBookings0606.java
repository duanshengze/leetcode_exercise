package com.difference.leetcode1109;

public class CorpFlightBookings0606 {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int len = bookings.length;
        int[] diff = new int[n + 1];


        for (int i = 0; i < len; i++) {
            diff[bookings[i][0] - 1] += bookings[i][2];
            diff[bookings[i][1]] -= bookings[i][2];
        }


        int[] ans = new int[n];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum = diff[i] + preSum;
            ans[i] = preSum;
        }

        return ans;

    }
}
