package com.dfs.leetcode416;

public class CanPartition {


    int[][] cache;

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

        for (int i = 0; i < cache.length; i++) {

            for (int j = 0; j < cache[0].length; j++) {

                cache[i][j] = -1;
            }
        }

        return dfs(nums, 0, target);

    }

    private boolean dfs(int[] nums, int index, int target) {

        if (index >= nums.length) {
            return false;
        }

        if (0 == target) {
            return true;
        }

        if (cache[index][target] != -1) {

            return cache[index][target] == 1;
        }

        boolean noSelect = dfs(nums, index + 1, target);
        if (noSelect) {
            cache[index][target] = 1;
            return true;
        }
        boolean select = false;
        if (target >= nums[index]) {
            select = dfs(nums, index + 1, target - nums[index]);
        }

        if (select) {
            cache[index][target] = 1;
        } else {
            cache[index][target] = 0;
        }
        return select;
    }
}
