package com.kmp.leetcode1392;

public class LongestPrefix {

    public String longestPrefix(String s) {
        int slen = s.length();
        int[] prefix = new int[slen];
        for (int i = 0; i < slen; i++) {
            prefix[i] = -1;
        }

        int index = 1;
        while (index < slen) {
            int j = prefix[index - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(index)) {
                j = prefix[j];
            }

            if (s.charAt(j + 1) == s.charAt(index)) {
                prefix[index] = j + 1;
            }
            index++;

        }


        return s.substring(0, prefix[slen - 1] + 1);

    }
}
