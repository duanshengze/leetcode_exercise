package com.sort.leetcode75;

public class SortColors0523 {

    public void sortColors(int[] nums) {
        int len = nums.length;
        int[] numCount = new int[3];

        for (int i = 0; i < len; i++) {
            numCount[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < numCount.length; i++) {
            while (numCount[i] > 0) {
                nums[index++] = i;
                numCount[i]--;
            }
        }


    }
}
