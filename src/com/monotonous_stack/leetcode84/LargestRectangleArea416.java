package com.monotonous_stack.leetcode84;

import java.util.Stack;

public class LargestRectangleArea416 {

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;

        int[] newHeight = new int[len + 2];

        for (int i=0;i<len;i++){
            newHeight[i+1]=heights[i];
        }

        int newLen = newHeight.length;

        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        for (int i = 0; i < newLen; i++) {

            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                int cur = stack.pop();
                int before = 0;
                if (!stack.isEmpty()) {
                    before = stack.peek();
                }
                int after = i;


                int s = newHeight[cur] * (after - before - 1);
                if (s > ans) {
                    ans = s;
                }

            }

            stack.add(i);

        }


        return ans;


    }
}
