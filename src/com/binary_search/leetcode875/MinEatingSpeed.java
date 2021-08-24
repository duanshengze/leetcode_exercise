package com.binary_search.leetcode875;

public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {

        int len = piles.length;
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            right = Math.max(piles[i], right);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            int count = find(piles, mid);

            if (count > h) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

    private int find(int[] piles, int mid) {

        int h = 0;
        for (int i = 0; i < piles.length; i++) {

            if (mid >= piles[i]) {
                h++;
            } else {
                if (piles[i]%mid==0){
                    h = h + piles[i] / mid;
                }else {
                    h = h + piles[i] / mid + 1;
                }

            }

        }

        return h;
    }
}
