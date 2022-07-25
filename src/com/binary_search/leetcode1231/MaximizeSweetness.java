package com.binary_search.leetcode1231;



public class MaximizeSweetness {

    public int maximizeSweetness(int[] sweetness, int k) {
        int len = sweetness.length;

        int left = 1;


        int right = 0;


        for (int i = 0; i < len; i++) {
            left = Math.min(sweetness[i], left);
            right += sweetness[i];
        }


        while (left < right) {

            int mid = (left + right) / 2;

            int count = find(sweetness, mid);

            if (count >= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int find(int[] sweetness, int mid) {

        int s = 0;
        int count = 1;
        for (int i = 0; i < sweetness.length; i++) {

            if (s + sweetness[i] > mid) {
                count++;
                s = 0;
            }
            s += sweetness[i];
        }

        return count;
    }
}
