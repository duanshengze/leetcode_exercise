package com.slide_window.leeytcode438;

import java.util.ArrayList;
import java.util.List;


public class FindAnagrams0523 {

    public List<Integer> findAnagrams(String s, String p) {

        int sLen = s.length();
        int pLen = p.length();

        int[] pCharsCount = new int[26];
        int[] sCharsCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCharsCount[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;

        List<Integer> ans = new ArrayList<>();
        while (right < sLen) {

            char c = s.charAt(right);
            sCharsCount[c - 'a']++;

            while (sCharsCount[c - 'a'] > pCharsCount[c - 'a'] || right - left + 1 > pLen) {
                char leftC = s.charAt(left);
                sCharsCount[leftC - 'a']--;
                left++;
            }

            if (sCharsCount[c - 'a'] == pCharsCount[c - 'a'] && right - left + 1 == pLen) {
                ans.add(left);
            }
            right++;

        }

        return ans;

    }
}
