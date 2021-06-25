package com.presum.leetcode930;

public class NumSubarraysWithSum0526 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        int[] preSumCount = new int[len + 1];
        preSumCount[0] = 1;

        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curSum = preSum + nums[i];
            if (curSum >= goal && preSumCount[curSum - goal] > 0) {
                ans = ans + preSumCount[curSum - goal];
            }
            preSumCount[curSum]++;
            preSum = curSum;
        }
        return ans;
    }


}
