package com.presum.leetcode974;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK0619 {

    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> preSumCount = new HashMap<>();

        preSumCount.put(0, 1);

        int preSum = 0;

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int curSum = preSum + nums[i];

            int div = (curSum % k + k) % k;

            Integer count = preSumCount.getOrDefault(div, 0);

            ans = ans + count;
            preSumCount.put(div, count + 1);

            preSum = curSum;
        }

        return ans;
    }
}
