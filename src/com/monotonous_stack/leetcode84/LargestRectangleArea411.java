package com.monotonous_stack.leetcode84;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleArea411 {
    /**
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        int[] newHeight = new int[len + 2];

        for (int i = 0; i < len; i++) {
            newHeight[i+1] = heights[i];
        }

        Stack<Integer> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < len + 2; i++) {

            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {

                int cur = stack.pop();


                int before = 0;
                if (!stack.isEmpty()) {
                    before = stack.peek();
                }

                int after = i;

                int s = newHeight[cur] * (after - before-1);

                if (s > max) {
                    max = s;
                }

            }

            stack.add(i);
        }


        return max;

    }
}
