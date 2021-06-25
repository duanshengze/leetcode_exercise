package com.sort.leetcode215;

public class FindKthLargest0605 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickFind(nums, 0, len - 1, len - k);
    }

    private int quickFind(int[] nums, int start, int end, int k) {

        int partation = partation(nums, start, end);

        if (partation > k) {
            return quickFind(nums, start, partation - 1, k);
        }

        if (partation < k) {
            return quickFind(nums, partation + 1, end, k);
        }

        return nums[k];

    }

    private int partation(int[] nums, int start, int end) {
        int pIndex = (int) (start + Math.random() * (end - start + 1));

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
