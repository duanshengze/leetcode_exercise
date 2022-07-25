package com.union_find.leetcode130;


public class Solve0501 {

    private int column;

    public void solve(char[][] board) {
        int xLen = board.length;
        int yLen = board[0].length;
        column = yLen;
        int visual = xLen * yLen;


        UnionFind unionFind = new UnionFind(xLen * yLen + 1);


        int[][] dir = new int[][]{{1, 0}, {0, 1}};
        // 上
        for (int i = 0, j = 0; j < yLen; j++) {
            if (board[i][j] == 'O') {
                unionFind.union(visual, getIndex(i, j));
            }
        }
        // 下
        for (int i = xLen - 1, j = 0; j < yLen; j++) {
            if (board[i][j] == 'O') {
                unionFind.union(visual, getIndex(i, j));
            }
        }


        // 左
        for (int i = 0, j = 0; i < xLen; i++) {
            if (board[i][j] == 'O') {
                unionFind.union(visual, getIndex(i, j));
            }
        }

        // 右
        for (int i = 0, j = yLen - 1; i < xLen; i++) {
            if (board[i][j] == 'O') {
                unionFind.union(visual, getIndex(i, j));
            }
        }


        for (int i = 0; i < xLen; i++) {

            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 'O') {


                    for (int k = 0; k < dir.length; k++) {
                        int nextX = i + dir[k][0];
                        int nextY = j + dir[k][1];
                        if (nextX < xLen && nextY < yLen && board[nextX][nextY] == 'O') {
                            unionFind.union(getIndex(i, j), getIndex(nextX, nextY));
                        }
                    }
                }

            }

        }

        int visualRoot = unionFind.find(visual);
        for (int i = 0; i < xLen; i++) {

            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 'O') {

                    int root = unionFind.find(getIndex(i, j));
                    if (root != visualRoot) {
                        board[i][j] = 'X';
                    }
                }

            }

        }


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
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY;
                return true;
            } else {
                return false;
            }
        }
    }
}
