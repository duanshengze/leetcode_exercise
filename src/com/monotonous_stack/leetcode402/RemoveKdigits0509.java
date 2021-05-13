package com.monotonous_stack.leetcode402;

import java.util.Stack;

public class RemoveKdigits0509 {

    public String removeKdigits(String num, int k) {

        int len = num.length();

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && num.charAt(stack.peek()) > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.add(i);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        char[] chars = new char[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            chars[index--] = num.charAt(stack.pop());
        }

        int noZeroStart = 0;

        for (; noZeroStart < chars.length; noZeroStart++) {
            if (chars[noZeroStart] != '0') {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = noZeroStart; i < chars.length; i++) {
            sb.append(chars[i]);
        }


        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}
