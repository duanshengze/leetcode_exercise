package com.slide_window.leecode1208;

public class EqualSubstring0523 {

    public int equalSubstring(String s, String t, int maxCost) {

        int len = s.length();

        int[] diff = new int[len];

        for (int i = 0; i < len; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0;
        int right = 0;

        int cost = 0;
        int max = 0;
        while (right < len) {
            cost = cost + diff[right];

            while (cost > maxCost) {
                cost = cost - diff[left];
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;

        }

        return max;

    }
}
