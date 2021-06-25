package com.slide_window.leetcode1004;

public class LongestOnes0605 {

    public int longestOnes(int[] nums, int k) {
        int len = nums.length;

        int left = 0;
        int right = 0;

        int ans = 0;
        while (right < len) {

            if (nums[right] == 0 && k >= 0) {
                k--;
            }

            if (k >= 0) {
                ans = Math.max(ans, right - left + 1);
            }
            while (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }



            right++;

        }
        return ans;
    }

}
