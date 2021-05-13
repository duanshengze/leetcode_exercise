package com.sort.leetcode912;

public class DumpSort {

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        //建立一个大根堆


    }


    private void heapAdjust(int[] nums, int start, int end) {
        if (start < end) {
            int root = nums[start];
            if (start * 2 < end && nums[start * 2] > root) {
                heapAdjust(nums, start * 2, end);
            }

            if (start * 2+1 < end && nums[start * 2+1] > root) {
                heapAdjust(nums, start * 2+1, end);
            }

        }
    }
}
