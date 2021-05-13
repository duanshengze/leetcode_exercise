package com.sort.leetcode912;

public class QuickSort57 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    private void quickSort(int[] nums, int left, int right) {

        if (left < right) {
            int pIndex = partation(nums, left, right);
            quickSort(nums, left, pIndex - 1);
            quickSort(nums, pIndex + 1, right);
        }
    }


    private int partation(int[] nums, int left, int right) {

        int pIndex = (int) (left + Math.random() * (right - left + 1));
        int p = nums[pIndex];
        swap(nums, pIndex, right);

        int index = left - 1;

        for (int i = left; i <= right; i++) {

            if (nums[i] < p) {
                index++;
                swap(nums, index, i);
            }
        }


        swap(nums, index + 1, right);
        return index + 1;

    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
