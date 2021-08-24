package com.kmp.leetcode28;

public class StrStr {

    public int strStr(String haystack, String needle) {


        int hLen = haystack.length();
        int nLen = needle.length();


        if (nLen == 0) {
            return 0;
        }
        int[] prefix = new int[nLen];


        int index = 1;

        while (index < nLen) {
            int j = prefix[index - 1];
            while (j > 0 && needle.charAt(j + 1) != needle.charAt(index)) {
                j = prefix[j - 1];
            }

            if (needle.charAt(j + 1) == needle.charAt(index)) {
                prefix[index] = j + 1;
            }
            index++;
        }


        int j = 0;
        for (int i = 0; i < hLen; i++) {

            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = prefix[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == nLen) {
                return i - nLen + 1;
            }
        }

        return -1;
    }
}
