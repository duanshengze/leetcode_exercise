package com.slide_window.leetcode1004;

public class LongestOnes0523 {


    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int max = 0;

        int left = 0;
        int right = 0;
        while (right < len) {
            if (nums[right] == 0 && k >= 0) {
                k--;
            }

            while (k < 0) {

                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }

            if (k >= 0) {
                max = Math.max(max, right - left + 1);
            }

            right++;
        }
        return max;

    }
}
