package com.presum.leetcode974;

import java.util.HashMap;

public class SubarraysDivByK0515 {

    public int subarraysDivByK(int[] nums, int k) {


        int len = nums.length;

        if (len == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0;

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curSum = preSum + nums[i];
            int s = (curSum % k + k) % k;
            int count = map.getOrDefault(s, 0);
            ans = ans + count;
            map.put(s, count + 1);
            preSum = curSum;
        }
        return ans;
    }
}
