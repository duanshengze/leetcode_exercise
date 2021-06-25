package com.stack.leetcode227;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculate {

    public int calculate(String s) {

        int len = s.length();

        char[] newStr = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                newStr[index++] = s.charAt(i);
            }
        }


        if (index < 1) {
            return 0;
        }

        Map<Character, Integer> optsPro = new HashMap<>();
        optsPro.put('+', 1);
        optsPro.put('-', 1);
        optsPro.put('/', 2);
        optsPro.put('*', 2);


        Stack<Integer> numsStack = new Stack<>();
        Stack<Character> optsStack = new Stack<>();

        for (int i = 0; i < index; i++) {
            char ch = newStr[i];
            if (isNum(ch)) {
                int j = i;
                int num = ch - '0';
                while (j + 1 < len && isNum(newStr[j + 1])) {
                    num = num * 10 + (newStr[j + 1] - '0');
                    j++;
                }
                numsStack.add(num);
                i = j;
            } else {

                while (!optsStack.isEmpty() && optsPro.get(optsStack.peek()) >= optsPro.get(ch)) {
                    calc(numsStack, optsStack);
                }
                optsStack.add(ch);

            }

        }

        while (!optsStack.isEmpty()) {
            calc(numsStack, optsStack);
        }

        return numsStack.peek();
    }

    private void calc(Stack<Integer> numsStack, Stack<Character> optsStack) {

        if (numsStack.size() < 2) {
            return;
        }
        if (optsStack.isEmpty()) {
            return;
        }
        int b = numsStack.pop();
        int a = numsStack.pop();
        char opt = optsStack.pop();
        int res = 0;
        switch (opt) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
            default:
                break;
        }
        numsStack.add(res);
    }


    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
