package com.slide_window.leetcode1004;

public class LongestOnes0620 {

    public int longestOnes(int[] nums, int k) {


        int len = nums.length;


        int left = 0;
        int right = 0;

        int zeroNum = 0;
        int max = 0;
        while (right < len) {

            if (nums[right] == 0) {
                zeroNum++;
            }

            if (zeroNum <= k) {
                max = Math.max(max, right - left + 1);
            }

            while (zeroNum > k) {
                if (nums[left] == 0) {
                    zeroNum--;
                }
                left++;
            }

            right++;

        }

        return max;

    }
}
