package com.slide_window.leetcode239;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        int left = 0;
        int right = 0;

        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int[] ans = new int[len - k+1];
        int i = 0;
        while (right < len) {
            queue.add(new int[]{nums[right], right});

            while (right - left + 1 > k) {
                left++;
            }

            while (queue.peek()[1] > right || queue.peek()[1] < left) {
                queue.poll();
            }

            if (right - left + 1 == k) {
                ans[i++] = queue.peek()[0];
            }

            right++;


        }

        return ans;

    }
}
