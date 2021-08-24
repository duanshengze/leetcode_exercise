package com.dfs.leetcode416;

public class CanPartition0711 {

    private int[][] cache;

    public boolean canPartition(int[] nums) {

        int len = nums.length;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        cache = new int[len][target + 1];

        return dfs(nums, 0, target);
    }

    private boolean dfs(int[] nums, int i, int taget) {

        if (i > nums.length - 1) {
            return false;
        }
        if (cache[i][taget] != 0) {
            return cache[i][taget] == 1;
        }

        if (0 == taget) {
            return true;
        }
        boolean ans = false;
        if (taget >= nums[i]) {
            ans = dfs(nums, i + 1, taget - nums[i]);
        }
        ans = (ans || dfs(nums, i + 1, taget));
        cache[i][taget] = ans ? 1 : -1;
        return ans;
    }
}
