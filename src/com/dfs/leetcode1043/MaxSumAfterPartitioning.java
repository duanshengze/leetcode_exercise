package com.dfs.leetcode1043;

public class MaxSumAfterPartitioning {

    private int[] cache;

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int len = arr.length;
        cache = new int[len];
        for (int i = 0; i < len; i++) {
            cache[i] = -1;
        }

        return dfs(arr, 0, k);
    }

    private int dfs(int[] arr, int start, int k) {
        int len = arr.length;

        if (start > len - 1) {
            return 0;
        }
        int end = start + k - 1;

        if (cache[start] != -1) {
            return cache[start];
        }

        if (end > len - 1) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= len - 1; i++) {
                max = Math.max(arr[i], max);
            }
            cache[start] = max * (len - start);
            return cache[start];
        } else {

            int max = Integer.MIN_VALUE;
            int now = Integer.MIN_VALUE;
            for (int i = start; i <= start + k - 1; i++) {
                max = Math.max(max, arr[i]);
                int tmp = max * (i - start + 1) + dfs(arr, i + 1, k);
                now = Math.max(tmp, now);
            }
            cache[start]=now;
            return now ;
        }


    }
}
