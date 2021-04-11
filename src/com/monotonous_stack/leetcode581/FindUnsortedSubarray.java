package com.monotonous_stack.leetcode581;

import java.util.Stack;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 */
public class FindUnsortedSubarray {

    /**
     * 使用单调栈解法
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;

        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;

        //从右往左遍历
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int left = stack.pop();
                int right = i;
                if (left < leftMin) {
                    leftMin = left;
                }

                if (right > rightMax) {
                    rightMax = right;
                }
            }
            stack.add(i);
        }


        if (rightMax < leftMin) {
            return 0;
        }

        // 从左往右遍历 解决用来 [1, 3, 2, 2, 2]
        stack.clear();

        for (int i = len-1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int right = stack.pop();
                int left = i;
                if (left < leftMin) {
                    leftMin = left;
                }

                if (right > rightMax) {
                    rightMax = right;
                }
            }
            stack.add(i);
        }


        return rightMax - leftMin + 1;

    }
}
