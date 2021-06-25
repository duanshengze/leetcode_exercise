package com.sort.leetcode179;

public class LargestNumber0618 {

    public String largestNumber(int[] nums) {

        int len = nums.length;

        mergeSort(nums, 0, len - 1);


        if (nums[0] == 0) {
            return "0";
        }

        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < len; i++) {
            strB.append(nums[i]);
        }

        return strB.toString();
    }

    private void mergeSort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int leftIndex = start;

        int rightIndex = mid + 1;
        int[] arr = new int[end - start + 1];
        int index = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (check(nums, leftIndex, rightIndex)) {
                arr[index++] = nums[leftIndex++];
            } else {
                arr[index++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            arr[index++] = nums[leftIndex++];
        }

        while (rightIndex <= end) {
            arr[index++] = nums[rightIndex++];
        }

        index = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = arr[index++];
        }

    }

    private boolean check(int[] nums, int aIndex, int bIndex) {
        long ab = 10;
        long ba = 10;
        int a = nums[aIndex];
        int b = nums[bIndex];
        int tmpA = nums[aIndex];
        int tmpB = nums[bIndex];


        while (tmpB / 10 != 0) {
            ab = ab * 10;
            tmpB = tmpB / 10;
        }

        ab = ab * a + b;
        while (tmpA / 10 != 0) {
            ba = ba * 10;
            tmpA = tmpA / 10;
        }

        ba = ba * b + a;
        return ab > ba;
    }
}
