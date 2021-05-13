package com.slide_window.leetcode1100;

public class NumKLenSubstrNoRepeats {

    public int numKLenSubstrNoRepeats(String S, int K) {

        int len = S.length();

        int[] charNum = new int[26];


        int left = 0;
        int right = 0;
        int count = 0;
        while (right < len) {
            charNum[S.charAt(right) - 'a']++;
            while (charNum[S.charAt(right) - 'a'] > 1 || right - left + 1 > K) {
                charNum[S.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == K) {
                count++;
            }
        }


        return count;

    }
}
