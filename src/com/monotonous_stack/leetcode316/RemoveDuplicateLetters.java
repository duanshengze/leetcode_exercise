package com.monotonous_stack.leetcode316;

import java.util.Stack;

public class RemoveDuplicateLetters {


    public String removeDuplicateLetters(String s) {
        int len = s.length();

        int[] num = new int[26];
        boolean[] isInStack = new boolean[26];
        for (int i = 0; i < len; i++) {
            num[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > ch) {
                if (num[stack.peek() - 'a'] > 1 && !isInStack[ch - 'a']) {
                    char pop = stack.pop();
                    isInStack[pop - 'a'] = false;
                    num[pop - 'a']--;
                } else {
                    break;
                }
            }

            if (!isInStack[ch - 'a']) {
                stack.add(ch);
                isInStack[ch - 'a'] = true;
            } else {
                num[ch - 'a']--;
            }

        }


        char[] res = new char[stack.size()];

        while (!stack.isEmpty()) {
            res[stack.size() - 1] = stack.pop();
        }

        return new String(res);
    }
}
