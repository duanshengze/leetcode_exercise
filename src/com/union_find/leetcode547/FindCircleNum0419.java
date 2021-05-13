package com.union_find.leetcode547;

public class FindCircleNum0419 {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }

            }
        }

        return unionFind.getCount();

    }


    private class UnionFind {

        private int[] parent;
        private int connCount;

        public UnionFind(int num) {
            this.connCount = num;
            parent = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = -1;
            }
        }


        public int find(int node) {
            while (parent[node] != -1) {
                node = parent[node];
            }
            return node;
        }


        public boolean union(int x, int y) {

            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot != yRoot) {
                parent[xRoot] = yRoot;
                connCount--;
                return true;
            } else {
                return false;
            }


        }


        public int getCount() {
            return connCount;
        }

    }


}
