package com.union_find.leetcode128;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive0505 {

    public int longestConsecutive(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        Set<Integer> set = map.keySet();
        UnionFind unionFind = new UnionFind(nums.length);

        for (Integer num : set) {
            if (set.contains(num + 1)) {
                unionFind.union(map.get(num), map.get(num + 1));
            }
        }

        int count = Integer.MIN_VALUE;

        for (Integer num : set) {
            int cur = unionFind.getCount(map.get(num));
            if (cur > count) {
                count = cur;
            }

        }

        return count;

    }

    private class UnionFind {
        private int[] parent;
        private int[] count;

        public UnionFind(int num) {
            parent = new int[num];
            count = new int[num];

            for (int i = 0; i < num; i++) {
                parent[i] = -1;
                count[i] = 1;
            }
        }


        public int find(int node) {
            while (parent[node] != -1) {
                node = parent[node];
            }
            return node;
        }


        public int getCount(int node) {
            int root = find(node);
            return count[root];

        }


        public boolean union(int x, int y) {

            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot != yRoot) {
                parent[xRoot] = yRoot;
                int sum = count[xRoot] + count[yRoot];
                count[xRoot] = sum;
                count[yRoot] = sum;
                return true;
            } else {
                return false;
            }

        }
    }
}
