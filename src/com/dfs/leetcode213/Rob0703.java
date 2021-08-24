package com.dfs.leetcode213;

public class Rob0703 {

    int[][] cache;

    public int rob(int[] nums) {

        int len = nums.length;

        cache = new int[len][2];

        for (int i = 0; i < len; i++) {
            cache[i][0] = -1;
            cache[i][1] = -1;
        }

        int rob = nums[0] + dfs(nums, 2, len - 2, 1);

        int noRob = nums[1] + dfs(nums, 1, len - 1, 0);

        return Math.max(rob, noRob);
    }

    private int dfs(int[] nums, int start, int end, int status) {

        if (start > end) {
            return 0;
        }

        if (cache[start][status] != -1) {
            return cache[start][status];
        }

        int rob = nums[start] + dfs(nums, start + 2, end, status);
        int noRob = dfs(nums, start + 1, end, status);

        int max = Math.max(rob, noRob);
        cache[start][status] = max;
        return max;
    }


}
