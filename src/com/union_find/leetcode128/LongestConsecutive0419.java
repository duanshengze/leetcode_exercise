package com.union_find.leetcode128;

import java.util.*;

public class LongestConsecutive0419 {


    public int longestConsecutive(int[] nums) {
        UnionFind unionFind = new UnionFind(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            set.add(nums[i]);
        }


        for (Integer e : set) {
            int next = e + 1;
            if (set.contains(next)) {
                unionFind.union(e, next);
            }
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = unionFind.getCount(nums[i]);
            if (count > max) {
                max = count;
            }
        }

        return max;

    }


    private class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> count;

        public UnionFind(int[] nums) {
            parent = new HashMap<>();
            count = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                parent.put(nums[i], -1);
                count.put(nums[i], 1);
            }

        }

        public int find(int node) {

            while (parent.get(node) != -1) {
                node = parent.get(node);
            }
            return node;
        }


        public boolean union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent.put(rootX, rootY);

                int countX = count.get(rootX);
                int countY = count.get(rootY);
                count.put(rootY, countX + countY);
                count.put(rootX, countX + countY);
                return true;
            } else {

                return false;
            }
        }

        public int getCount(int node) {
            int root = find(node);
            return count.get(root);
        }


    }
}
