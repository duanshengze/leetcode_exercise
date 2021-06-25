package com.presum.leetcode1248;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] oddNum = new int[len+1];
        int preSum = 0;
        oddNum[0] = 1;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int check = nums[i] & 1;
            int curSum = preSum + check;

            int count = curSum < k ? 0 : oddNum[curSum - k];
            ans = count+ ans;
            oddNum[curSum]++;
            preSum = curSum;
        }

        return ans;
    }
}
