package com.slide_window.leetcode1100;

public class NumKLenSubstrNoRepeats0523 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        int len = s.length();

        int[] charCount = new int[26];

        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < len) {

            int cIndex = s.charAt(right) - 'a';
            charCount[cIndex]++;

            while (charCount[cIndex] > 1 || right - left + 1 > k) {
                charCount[s.charAt(left) - 'a']--;
                left++;
            }

            if (charCount[cIndex] == 1 && right - left + 1 == k) {
                ans++;
            }
            right++;
        }

        return ans;


    }
}
