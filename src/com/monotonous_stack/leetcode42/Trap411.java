package com.monotonous_stack.leetcode42;


import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trap411 {

    /**
     * 使用单调栈 耗时13分钟 运行成功
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {

                int mid = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int before = stack.peek();
                int after = i;
                int s =( Math.min(height[before],height[after])-height[mid])* (after - before - 1);
                ans = ans + s;

            }

            stack.add(i);
        }

        return ans;
    }
}
