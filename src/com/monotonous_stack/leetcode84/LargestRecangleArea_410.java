package com.monotonous_stack.leetcode84;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRecangleArea_410 {


    /**
     * 使用单调栈加哨兵方法
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea_01(int[] heights) {

        int len = heights.length;

        int[] newHeights = new int[len + 2];

        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }


        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int mid = stack.pop();
                int before = stack.peek();
                int after = i;
                int s = newHeights[mid] * (after - before-1);
                if (s > ans) {
                    ans = s;
                }

            }
            stack.add(i);
        }


        return ans;

    }
}
