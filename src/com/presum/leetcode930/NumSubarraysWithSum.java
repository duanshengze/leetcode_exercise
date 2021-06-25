package com.presum.leetcode930;

public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {

        int len = nums.length;
        int[] presumCount = new int[len + 1];
        presumCount[0] = 1;

        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curSum = preSum + nums[i];

            if (curSum >= goal) {
                ans = ans + presumCount[curSum - goal];
            }
            presumCount[curSum]++;
            preSum = curSum;

        }

        return ans;

    }
}
