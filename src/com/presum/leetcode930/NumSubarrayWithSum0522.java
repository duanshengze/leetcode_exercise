package com.presum.leetcode930;

public class NumSubarrayWithSum0522 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;

        int[] preSumCount = new int[len + 1];

        preSumCount[0] = 1;

        int preSum = 0;

        int count = 0;
        for (int i = 0; i < len; i++) {
            int curSum = preSum + nums[i];

            if (curSum - goal >= 0 && preSumCount[curSum - goal] > 0) {
                count=preSumCount[curSum - goal]+count;
            }
            preSumCount[curSum]++;

            preSum = curSum;
        }
        return count;

    }
}
