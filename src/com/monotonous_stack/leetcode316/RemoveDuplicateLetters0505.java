package com.monotonous_stack.leetcode316;

import java.util.Stack;

public class RemoveDuplicateLetters0505 {


    public String removeDuplicateLetters(String s) {
        int len = s.length();
        int[] nums = new int[26];
        boolean[] isInStack = new boolean[26];

        for (int i = 0; i < len; i++) {
            nums[s.charAt(i) - 'a']++;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && nums[s.charAt(stack.peek()) - 'a'] > 1
                    && s.charAt(stack.peek()) > s.charAt(i)
                    && !isInStack[s.charAt(i) - 'a']) {
                Integer pop = stack.pop();
                nums[s.charAt(pop) - 'a']--;
                isInStack[s.charAt(pop) - 'a'] = false;
            }

            if (isInStack[s.charAt(i) - 'a']) {
                nums[s.charAt(i) - 'a']--;
            } else {
                stack.add(i);
                isInStack[s.charAt(i) - 'a'] = true;
            }

        }


        char[] chars = new char[stack.size()];

        int index = chars.length - 1;

        while (!stack.isEmpty()) {
            chars[index--] = s.charAt(stack.pop());
        }

        return new String(chars);

    }
}
