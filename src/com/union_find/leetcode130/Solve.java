package com.union_find.leetcode130;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *  
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solve {

    public void solve(char[][] board) {

        int xLen = board.length;
        int yLen = board[0].length;

        UnionFind unionFind = new UnionFind(xLen * yLen + 1);

        int vistual = xLen * yLen ;
        //周围的 "O"
        // 左边
        for (int i = 0, j = 0; i < xLen; i++) {
            if (board[i][j] == 'O') {
                unionFind.union(getIndex(i, xLen, j), vistual);
            }
        }
        //右边
        for (int i = 0, j = yLen - 1; i < xLen; i++) {
            if (board[i][j] == 'O') {
                unionFind.union(getIndex(i, xLen, j), vistual);
            }
        }

        //上边
        for (int i = 0, j = 0; j < yLen; j++) {
            if (board[i][j] == 'O') {
                unionFind.union(getIndex(i, xLen, j), vistual);
            }
        }

        //下边
        for (int i = xLen - 1, j = 0; j < yLen; j++) {
            if (board[i][j] == 'O') {
                unionFind.union(getIndex(i, xLen, j), vistual);
            }
        }

        int[][] direct = new int[][]{{0, 1}, {1, 0}};
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < direct.length; k++) {
                        int down = i + direct[k][0];
                        int right = j + direct[k][1];
                        if (down < xLen && right < yLen && board[down][right] == 'O') {
                            unionFind.union(getIndex(down, xLen, right), getIndex(i, xLen, j));
                        }
                    }

                }
            }
        }

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 'O') {
                    if (!unionFind.isConnect(getIndex(i, xLen, j), vistual)) {
                        board[i][j] = 'X';
                    }

                }
            }
        }

    }


    private int getIndex(int x, int xlen, int y) {
        return x * xlen + y;
    }


    private class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int num) {
            this.parent = new int[num];
            this.rank = new int[num];
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

        public boolean isConnect(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return true;
            } else {
                return false;
            }
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
                    parent[yRoot] = xRoot;
                    rank[xRoot]++;
                }
                return true;
            }
        }

    }


}
