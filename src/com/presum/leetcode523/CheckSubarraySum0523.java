package com.presum.leetcode523;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum0523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        int len = nums.length;

        Map<Integer, Integer> preSumDiv = new HashMap<>();

        preSumDiv.put(0, -1);

        int preSum = 0;

        for (int i = 0; i < len; i++) {
            int curSum = preSum + nums[i];
            int div = (curSum % k + k) % k;

            if (preSumDiv.containsKey(div)) {
                Integer minIndex = preSumDiv.get(div);
                if (i - minIndex >= 2) {
                    return true;
                }
            } else {
                preSumDiv.put(div, i);
            }

            preSum = curSum;
        }
        return false;
    }
}
