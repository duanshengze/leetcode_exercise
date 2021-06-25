package com.sort.leetcode912;

public class DumpSort0523 {

    public int[] sortArray(int[] nums) {
        return dumpSort(nums);
    }

    private int[] dumpSort(int[] nums) {

        buildMaxHeap(nums);

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            maxHeapAdjust(nums, 0, i - 1);
        }

        return nums;

    }


    private void buildMaxHeap(int[] nums) {
        int len = nums.length;

        for (int i = len / 2; i >= 0; i--) {
            maxHeapAdjust(nums, i, len - 1);
        }


    }

    private void maxHeapAdjust(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int maxIndex = start;

        int left = start * 2;
        int right = start * 2 + 1;

        if (left <= end && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }

        if (right <= end && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != start) {
            swap(nums, maxIndex, start);
            maxHeapAdjust(nums, maxIndex, end);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }


}
