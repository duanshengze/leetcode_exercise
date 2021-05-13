package com.sort.leetcode215;

public class FindKthLargest0509 {

    public int findKthLargest(int[] nums, int k) {
        return quickFindKLargest(nums, 0, nums.length - 1, nums.length - k);
    }


    private int quickFindKLargest(int[] nums, int start, int end, int k) {
        int partaionIndex = partation(nums, start, end);
        if (partaionIndex > k) {
            return quickFindKLargest(nums, 0, partaionIndex - 1, k);
        } else if (partaionIndex == k) {
            return nums[k];
        } else {
            return quickFindKLargest(nums, partaionIndex + 1, end, k);
        }

    }

    private int partation(int[] nums, int start, int end) {
        int rand = (int) (start + Math.random() * (end - start + 1));
        int p = nums[rand];
        int index = start - 1;
        swap(nums, rand, end);
        for (int i = start; i < end; i++) {
            if (nums[i] < p) {
                index++;
                swap(nums, i, index);
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
