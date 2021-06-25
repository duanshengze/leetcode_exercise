package com.presum.leetcode974;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK0523 {


    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> preSumDivCount = new HashMap<>();

        preSumDivCount.put(0, 1);

        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curSum = preSum + nums[i];
            int div = (curSum % k + k) % k;
            int count = preSumDivCount.getOrDefault(div, 0);
            ans = ans + count;
            preSumDivCount.put(div, count + 1);
            preSum = curSum;
        }

        return ans;
    }
}
