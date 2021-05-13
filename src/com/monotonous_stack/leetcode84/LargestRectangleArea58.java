package com.monotonous_stack.leetcode84;

import java.util.Stack;

public class LargestRectangleArea58 {

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            right[stack.pop()] = len;
        }

        for (int i = len-1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }


        int ans = 0;


        for (int i = 0; i < len; i++) {

            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);

        }
        return ans;

    }
}
