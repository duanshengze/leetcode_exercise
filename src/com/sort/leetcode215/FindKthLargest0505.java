package com.sort.leetcode215;

public class FindKthLargest0505 {


    public int findKthLargest(int[] nums, int k) {

       return quickFind(nums, 0, nums.length - 1, nums.length - 1 - k);
    }


    private int partation(int[] nums, int start, int end) {
        int pIndex = (int) (start + Math.random() * (end - start + 1));

        int p = nums[pIndex];
        swap(nums, pIndex, end);

        int index = start - 1;

        for (int i = start; i <= end; i++) {

            if (nums[i] < p) {
                index++;
                swap(nums, index, i);
            }
        }

        swap(nums, index + 1, end);
        return index + 1;
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    private int quickFind(int[] nums, int start, int end, int k) {


        int partation = partation(nums, start, end);

        if (partation == k) {
            return nums[partation];
        } else if (partation > k) {
            return quickFind(nums, start, partation - 1, k);
        } else {
            return quickFind(nums, partation + 1, end, k);
        }
    }
}
