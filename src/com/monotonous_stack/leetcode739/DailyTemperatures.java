package com.monotonous_stack.leetcode739;

import java.util.Stack;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {


    /**
     * 单调栈解法
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {

        int len = T.length;
        int[] days = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                Integer pop = stack.pop();
                days[pop] = i - pop;
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            days[stack.pop()] = 0;
        }

        return days;
    }
}
