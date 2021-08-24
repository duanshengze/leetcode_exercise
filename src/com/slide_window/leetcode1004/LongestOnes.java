package com.slide_window.leetcode1004;

public class LongestOnes {

    public int longestOnes(int[] nums, int k) {

        int len = nums.length;

        int left = 0;
        int right = 0;

        int max = 0;
        while (right < len) {


            while (right >= left && nums[right] == 0 && k <= 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }

            if (nums[right] == 0 && k > 0) {
                k--;
            }

            max = Math.max(max, right - left + 1);
            right++;

        }
        return max;
    }
}
