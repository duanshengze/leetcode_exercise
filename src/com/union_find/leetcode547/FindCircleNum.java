package com.union_find.leetcode547;

public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        int xLen = isConnected.length;
        int yLen = isConnected[0].length;
        UnionFind unionFind = new UnionFind(xLen);
        int count = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = i + 1; j < yLen; j++) {
                if (isConnected[i][j] == 1 && unionFind.union(i, j)) {
                    count++;
                }
            }
        }
        return xLen - count;
    }


    class UnionFind {
        int[] parent;
        int[] rank;


        public UnionFind(int size) {
            this.parent = new int[size];
            this.rank = new int[size];

            for (int i = 0; i < size; i++) {
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

            if (xRoot == yRoot) {
                return false;
            } else {
                if (rank[xRoot] > rank[yRoot]) {
                    parent[yRoot] = xRoot;
                } else if (rank[xRoot] < rank[yRoot]) {
                    parent[xRoot] = yRoot;
                } else {
                    parent[xRoot] = yRoot;
                    rank[yRoot]++;
                }

                return true;
            }
        }
    }
}
