package com.slide_window.leecode1208;

public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {

        int len = s.length();


        int left = 0;
        int right = 0;

        int[] cost = new int[len];

        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int sum = 0;
        int max = 0;
        while (right < len) {
            sum = sum + cost[right];

            while (sum > maxCost) {
                sum = sum - cost[left];
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;

    }
}
