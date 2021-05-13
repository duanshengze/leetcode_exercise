package com.sort.leetcode912;

import javax.sound.sampled.Line;
import java.util.Random;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partation = partation(arr, start, end);
            quickSort(arr, start, partation - 1);
            quickSort(arr, partation + 1, end);
        }
    }

    private int partation(int[] nums, int start, int end) {
        int preIndex = new Random().nextInt(end -start + 1) + start;
        int p = nums[preIndex];
        swap(nums, preIndex, end);

        int index = start - 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] < p) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, index+1, end);
        return index+1;
    }


    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

}
