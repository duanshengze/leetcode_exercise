package com.union_find.leetcode128;

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 *  
 * <p>
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {


    public int longestConsecutive(int[] nums) {

        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }

        UnionFind unionFind = new UnionFind(set);

        for (Integer e : set) {
            if (set.contains(e + 1)) {
                unionFind.union(e, e + 1);
            }
        }

        int max = 1;

        for (Integer e : set) {
            int count = unionFind.count(e);
            if (max < count) {
                max = count;
            }
        }

        return max;

    }


    private class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> count;

        public UnionFind(Set<Integer> set) {

            this.parent = new HashMap<Integer, Integer>();
            this.count = new HashMap<Integer, Integer>();


            for (Integer i : set) {
                parent.put(i, -1);
                count.put(i, 1);
            }

        }


        public int find(int node) {
            while (parent.get(node) != -1) {
                node = parent.get(node);
            }
            return node;
        }


        public boolean union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return false;
            } else {

                parent.put(xRoot, yRoot);
                int xCount = count.get(xRoot);
                int yCount = count.get(yRoot);
                int sum = xCount + yCount;
                count.put(xRoot, sum);
                count.put(yRoot, sum);

                return true;
            }

        }

        public int count(int node) {
            return count.get(node);
        }
    }

}
