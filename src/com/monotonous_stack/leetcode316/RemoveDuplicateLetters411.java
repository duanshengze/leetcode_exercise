package com.monotonous_stack.leetcode316;


import java.util.Stack;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters411 {


    /**
     * 执行成功 耗时 35 分钟
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {

        int len = s.length();

        int[] nums = new int[26];

        for (int i = 0; i < len; i++) {
            nums[s.charAt(i) - 'a']++;
        }

        boolean[] isInStack = new boolean[26];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && s.charAt(stack.peek()) > s.charAt(i)&&!isInStack[s.charAt(i)-'a']) {


                int pre = stack.peek();
                if (nums[s.charAt(pre)-'a'] > 1) {
                    stack.pop();
                    nums[s.charAt(pre)-'a']--;
                    isInStack[s.charAt(pre)-'a'] = false;
                } else {
                    break;
                }

            }

            if (!isInStack[s.charAt(i)-'a']) {
                stack.add(i);
                isInStack[s.charAt(i)-'a'] = true;
            }else {
                nums[s.charAt(i)-'a']--;
            }

        }

        int lenStack = stack.size();
        char[] chars = new char[lenStack];
        int index = lenStack - 1;
        while (!stack.isEmpty()) {
            chars[index--] = s.charAt(stack.pop());
        }
        return new String(chars);
    }
}
