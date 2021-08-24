package com.dfs.leetcode213;

public class Rob {

    public int rob(int[] nums) {

        int len = nums.length;

        int[][] visited = new int[len][2];

        for (int i = 0; i < len; i++) {
            visited[i][0] = -1;
            visited[i][1] = -1;
        }

        int rob = nums[0] + dfs(nums, 2, len - 2, visited, 1);

        int noRob = dfs(nums, 1, len - 1, visited, 0);

        return Math.max(rob, noRob);
    }

    private int dfs(int[] nums, int start, int end, int[][] visited, int status) {

        if (start > end) {
            return 0;
        }


        if (visited[start][status] != -1) {
            return visited[start][status];
        }


        int rob = nums[start] + dfs(nums, start + 2, end, visited, status);

        int noRob = dfs(nums, start + 1, end, visited, status);
        int max = Math.max(rob, noRob);
        visited[start][status] = max;
        return max;
    }
}
