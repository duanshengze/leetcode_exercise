package com.sort.leetcode75;

public class SortColors {

    public void sortColors(int[] nums) {
        int len = nums.length;

        int[] numCount = new int[3];

        for (int i = 0; i < len; i++) {
            numCount[nums[i]]++;
        }
        int index = 0;
        while (index < len) {

            int i = 0;
            while (i < 3) {
                if (numCount[i] > 0) {
                    nums[index++] = i;
                    numCount[i]--;
                } else if (numCount[i] == 0) {
                    i++;
                }
            }
        }

    }
}
