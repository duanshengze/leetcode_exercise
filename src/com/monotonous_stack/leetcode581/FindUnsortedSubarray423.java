package com.monotonous_stack.leetcode581;

import java.util.Stack;

public class FindUnsortedSubarray423 {

    /**
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {

        int len = nums.length;

        int leftMin = len;

        int rightMax = -1;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {

                Integer pop = stack.pop();
                if (pop < leftMin) {
                    leftMin = pop;
                }
            }

            stack.add(i);

        }

        stack.clear();

        for (int i = len - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {

                Integer pop = stack.pop();
                if (pop > rightMax) {
                    rightMax = pop;
                }
            }

            stack.add(i);

        }


        if (rightMax < leftMin) {
            return 0;
        }

        return rightMax - leftMin + 1;


    }
}
