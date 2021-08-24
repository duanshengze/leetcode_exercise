package com.stack.leetcode227;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculate0703 {

    public int calculate(String s) {

        int lenS = s.length();

        char[] chars = new char[lenS];
        int index = 0;
        for (int i = 0; i < lenS; i++) {

            if (s.charAt(i) != ' ') {
                chars[index++] = s.charAt(i);
            }
        }

        Map<Character, Integer> optsOpri = new HashMap<>();
        optsOpri.put('+', 1);
        optsOpri.put('-', 1);
        optsOpri.put('*', 2);
        optsOpri.put('/', 2);

        Stack<Character> opts = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < index; i++) {
            char ch = chars[i];
            if (isNum(ch)) {
                int j = i;
                int num = chars[j] - '0';
                while (j + 1 < index && isNum(chars[j + 1])) {
                    num = num * 10 + (chars[j + 1] - '0');
                    j++;
                }
                nums.add(num);
                i = j;
            } else {

                while (!opts.isEmpty() && optsOpri.get(ch) <= optsOpri.get(opts.peek())) {
                    calc(nums, opts);
                }
                opts.add(ch);

            }

        }

        while (!opts.isEmpty()) {
            calc(nums, opts);
        }

        return nums.peek();

    }

    private void calc(Stack<Integer> nums, Stack<Character> opts) {

        if (nums.size() < 2 || opts.isEmpty()) {
            return;
        }

        int b = nums.pop();
        int a = nums.pop();

        char opt = opts.pop();

        int num = 0;
        switch (opt) {
            case '+':
                num = a + b;
                break;
            case '-':
                num = a - b;
                break;
            case '/':
                num = a / b;
                break;
            case '*':
                num = a * b;
                break;


        }
        nums.add(num);
    }


    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
