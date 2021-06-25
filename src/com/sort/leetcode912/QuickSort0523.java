package com.sort.leetcode912;

public class QuickSort0523 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int partation = partation(nums, start, end);
        quickSort(nums, start, partation - 1);
        quickSort(nums, partation + 1, end);
    }


    private int partation(int[] nums, int start, int end) {
        int pIndex = (int) (start + Math.random() * (end - start - 1));

        int p = nums[pIndex];
        swap(nums, pIndex, end);

        int index = start - 1;

        for (int i = start; i < end; i++) {

            if (nums[i] < p) {
                index++;
                swap(nums, index, i);
            }
        }

        index++;
        swap(nums, index, end);
        return index;
    }


    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}

