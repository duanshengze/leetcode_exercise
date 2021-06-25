package com.dynamic_program.leetcode5;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int sLen = s.length();

        boolean[][] dp = new boolean[sLen][sLen];


        int startIndex = 0;
        int endIndex = 0;
        int max = 1;
        for (int len = 1; len <=sLen; len++) {

            for (int start = 0; start < sLen; start++) {
                int end = start + len - 1;
                if (end >= sLen) {
                    continue;
                }
                if (len == 1) {
                    dp[start][end] = true;
                }
                if (len == 2) {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = true;
                    }
                } else if (len > 2) {
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = dp[start + 1][end - 1];
                    }
                }

                if (dp[start][end] && len > max) {
                    startIndex = start;
                    endIndex = end;
                    max = len;
                }
            }

        }


        return s.substring(startIndex, endIndex + 1);


    }

}
