package com.monotonous_stack.leetcode84;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;

        Stack<Integer> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer index = stack.peek();
                int area = heights[index] * (i - index);
                if (area > max) {
                    max = area;
                }
                stack.pop();
            }
            stack.add(i);
        }

        int preIndex = 0;
        if (stack.size() > 1) {
            preIndex = stack.pop();
            int area = heights[preIndex];
            if (area > max) {
                max = area;
            }
        } else if (stack.size() == 1) {
           int  index = stack.pop();
            int area = heights[index] * len;
            if (area > max) {
                max = area;
            }
        }


        while (stack.size() > 1) {
            Integer index = stack.peek();
            int area=heights[index]*(preIndex-index+1);
            if (area > max) {
                max = area;
            }
            stack.pop();
        }

        if (stack.size() == 1) {
            int  index = stack.pop();
            int area = heights[index] * len;
            if (area > max) {
                max = area;
            }
        }


        return max;


    }
}
