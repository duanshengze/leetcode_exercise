package com.binary_search.leetcode1011;

public class ShipWithinDays {


    public int shipWithinDays(int[] weights, int days) {
        int len = weights.length;

        int left = weights[0];
        int right = 0;


        for (int i = 0; i < len; i++) {
            right += weights[i];
        }




        while (left <= right) {

            int mid = (left + right) / 2;
            int need = need(weights, mid);
            if (need <= days) {

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int need(int[] weights, int mid) {
        int sum = 0;
        int check = 1;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > mid) {
                check++;
                sum = weights[i];
            } else if (sum == mid) {
                check++;
                sum = 0;
            }


        }
        return check;
    }
}
