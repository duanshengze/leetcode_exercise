package com.sort.leetcode912;

public class MergeSort0523 {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }


    private void mergeSort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int[] tmp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {

            if (nums[left] > nums[right]) {
                tmp[index++] = nums[right++];
            } else {
                tmp[index++] = nums[left++];
            }
        }

        while (left <= mid) {
            tmp[index++] = nums[left++];
        }

        while (right <= end) {
            tmp[index++] = nums[right++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = tmp[i - start];
        }

    }
}
