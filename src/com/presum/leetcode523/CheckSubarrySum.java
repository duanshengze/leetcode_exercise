package com.presum.leetcode523;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarrySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        int len = nums.length;

        Map<Integer, Integer> map = new HashMap();

        map.put(0, -1);

        int preSum = 0;

        for (int i = 0; i < len; i++) {

            int curSum = preSum + nums[i];

            int remain = curSum % k;

            if (map.get(remain) == null) {
                map.put(remain, i);
                continue;
            } else {

                int index = map.get(remain);
                if (i - index >= 2) {
                    return true;
                }
            }


            preSum = curSum;

        }


        return false;


    }
}
