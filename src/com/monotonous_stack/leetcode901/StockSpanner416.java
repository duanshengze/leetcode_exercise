package com.monotonous_stack.leetcode901;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner416 {

    private Stack<Integer> stack = new Stack<>();

    private List<Integer> list = new ArrayList<>();


    private int nextDay;

    public StockSpanner416() {

    }

    public int next(int price) {

        int curDay = nextDay;
        while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }
        int ans = 0;
        if (!stack.isEmpty()) {
            ans = curDay - stack.peek() + 1;
        } else {
            ans = curDay;
        }
        list.add(curDay, price);
        stack.add(curDay);
        nextDay++;
        return ans;

    }
}
