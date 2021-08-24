package com.monotonous_stack.leetcode901;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner0704 {


    Stack<Integer> stack = new Stack<>();

    List<Integer> stockSpanner = new ArrayList<>();

    private int preDay = -1;

    public StockSpanner0704() {

    }

    public int next(int price) {

        int curDay = preDay + 1;

        while (!stack.isEmpty() && stockSpanner.get(stack.peek()) <= price) {
            stack.pop();
        }

        int ans = 0;
        if (stack.isEmpty()) {
            ans = curDay + 1;
        } else {
            ans = curDay - stack.peek();
        }

        stack.push(curDay);
        stockSpanner.add(price);
        preDay = curDay;
        return ans;

    }
}
