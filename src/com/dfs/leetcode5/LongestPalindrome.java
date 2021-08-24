package com.dfs.leetcode5;

public class LongestPalindrome {

    int[][] cache;

    public String longestPalindrome(String s) {
        int len = s.length();

        int max = 1;
        int start = 0;
        int end = 0;
        cache = new int[len][len];



        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (dfs(s, i, j) && max < j - i + 1) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);

    }

    private boolean dfs(String s, int start, int end) {

        if (start == end) {

            return true;
        }
        if (end - start == 1) {
            return s.charAt(start) == s.charAt(end);
        }

        if (cache[start][end] != 0) {
            return cache[start][end] == 1;
        }

        boolean res = false;
        if (s.charAt(start) == s.charAt(end)) {
            res = dfs(s, start + 1, end - 1);
        }

        if (res) {
            cache[start][end] = 1;
        } else {
            cache[start][end] = -1;
        }
        return res;

    }
}
