package com.presum.leetcode560;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum0619 {

    public int subarraySum(int[] nums, int k) {

        int len = nums.length;
        Map<Integer, Integer> preSumCount = new HashMap<>();
        preSumCount.put(0, 1);


        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curSum = preSum + nums[i];


            ans = ans + preSumCount.getOrDefault(curSum - k, 0);

            Integer count = preSumCount.getOrDefault(curSum, 0);

            preSumCount.put(curSum, count + 1);
            preSum = curSum;
        }
        return ans;
    }
}
