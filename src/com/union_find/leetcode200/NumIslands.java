package com.union_find.leetcode200;


/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int count = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }

        int[][] dir = new int[][]{{1, 0}, {0, 1}};
        UnionFind unionFind = new UnionFind(xLen * yLen);
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < dir.length; k++) {
                        int nextX = i + dir[k][0];
                        int nextY = j + dir[k][1];
                        if (nextX < xLen && nextY < yLen && grid[nextX][nextY] == '1') {
                            boolean is = unionFind.union(getIndex(i, j, yLen), getIndex(nextX, nextY, yLen));
                            if (is) {
                                count--;
                            }
                        }

                    }

                }
            }
        }


        return count;


    }

    private int getIndex(int x, int y, int col) {
        return x * col + y;

    }

    private class UnionFind {
        private int[] parent;


        public UnionFind(int num) {

            this.parent = new int[num];


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

            if (rootX == rootY) {
                return false;
            } else {
                parent[rootX] = rootY;
                return true;
            }

        }
    }


}
