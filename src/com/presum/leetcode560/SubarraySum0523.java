package com.presum.leetcode560;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum0523 {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> preSumCount = new HashMap<>();

        preSumCount.put(0, 1);

        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curSum = preSum + nums[i];


            int count = preSumCount.getOrDefault(curSum - k, 0);
            ans = ans + count;

            preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) + 1);

            preSum = curSum;

        }

        return ans;


    }
}
