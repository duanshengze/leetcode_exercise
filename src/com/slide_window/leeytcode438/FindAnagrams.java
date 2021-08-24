package com.slide_window.leeytcode438;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {


    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();

        int[] pCharNum = new int[26];

        for (int i = 0; i < pLen; i++) {

            pCharNum[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        int[] sCharNum = new int[26];
        List<Integer> ans = new ArrayList<>();

        while (right < s.length()) {
            int indexR = s.charAt(right) - 'a';
            sCharNum[indexR]++;
            while (sCharNum[indexR] > pCharNum[indexR] || right - left + 1 > pLen) {
                int indexL = s.charAt(left) - 'a';
                sCharNum[indexL]--;
                left++;
            }

            if (right - left + 1 == pLen && sCharNum[indexR] == pCharNum[indexR]) {
                ans.add(left);
            }

            right++;
        }

        return ans;
    }


}
