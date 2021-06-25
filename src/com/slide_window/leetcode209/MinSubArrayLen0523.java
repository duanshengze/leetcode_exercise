package com.slide_window.leetcode209;

import java.util.Map;

public class MinSubArrayLen0523 {
    public int minSubArrayLen(int target, int[] nums) {

        int len = nums.length;

        int left = 0;
        int right = 0;
        int min = len + 1;
        int sum = 0;
        while (right < len) {
            sum = sum + nums[right];

            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum = sum - nums[left];
                left++;
            }

            right++;
        }

        if (min == len + 1) {
            return 0;
        }
        return min;

    }
}
