package com.union_find.leetcode200;

public class NumIslands0505 {

    private int column;

    public int numIslands(char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        column = yLen;

        UnionFind unionFind = new UnionFind(xLen * yLen);

        int[][] dir = new int[][]{{1, 0}, {0, 1}};

        int count = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {

                if (grid[i][j] == '1') {
                    count++;
                }


            }
        }

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {

                if (grid[i][j] == '1') {
                    for (int k = 0; k < dir.length; k++) {

                        int nextX = i + dir[k][0];
                        int nextY = j + dir[k][1];

                        if (nextX < xLen && nextY < yLen && grid[nextX][nextY] == '1') {
                            boolean suc = unionFind.union(getIndex(i, j), getIndex(nextX, nextY));
                            if (suc) {
                                count--;
                            }
                        }


                    }
                }


            }
        }

        return count;
    }

    private int getIndex(int x, int y) {
        return x * column + y;
    }


    private class UnionFind {
        private int[] parent;


        public UnionFind(int num) {
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

                return true;
            } else {
                return false;
            }
        }


    }
}
