package com.sort.leetcode147;

import com.sun.tools.internal.ws.resources.GeneratorMessages;

public class InsertionSortList0516 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        buildHeap(nums);
        int i = 1;
        while (i < k) {
            swap(nums, 0, len - i);
            maxAdjust(nums, 0, len - i - 1);
            i++;
        }
        return nums[0];
    }


    private void buildHeap(int[] nums) {
        int len = nums.length;

        int end = len - 1;
        int start = end / 2;
        for (; start >= 0; start--) {
            maxAdjust(nums, start, end);
        }
    }


    private void maxAdjust(int[] nums, int start, int end) {

        int left = start * 2 + 1;
        int right = start * 2 +2;
        int maxIndex = start;
        if (left <= end && nums[left] >nums[maxIndex]) {
            maxIndex = left;
        }

        if (right <= end && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != start) {
            swap(nums, maxIndex, start);
            maxAdjust(nums, maxIndex, end);
        }

    }


    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
