package com.monotonous_stack.leetcode316;

import java.util.Stack;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters {

    /**
     * 单调栈解法
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int len = s.length();

        int[] num = new int[26];
        boolean[] isInStack = new boolean[26];
        for (int i = 0; i < len; i++) {
            num[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > ch) {
                if (num[stack.peek() - 'a'] > 1 && !isInStack[ch - 'a']) {
                    char pop = stack.pop();
                    isInStack[pop - 'a'] = false;
                    num[pop - 'a']--;
                } else {
                    break;
                }
            }

            if (!isInStack[ch - 'a']) {
                stack.add(ch);
                isInStack[ch - 'a'] = true;
            } else {
                num[ch - 'a']--;
            }

        }


        char[] res = new char[stack.size()];

        while (!stack.isEmpty()) {
            res[stack.size() - 1] = stack.pop();
        }

        return new String(res);
    }
}
