package com.dfs.leetcode934;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {


    private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean[][] visited;

    private Queue<Fragment> queue = new LinkedList<>();


    private class Fragment {

        private int[] ponit;
        private int level;

        public Fragment(int x, int y, int level) {
            ponit = new int[]{x, y};
            this.level = level;
        }
    }

    public int shortestBridge(int[][] grid) {
        int lenX = grid.length;
        int lenY = grid[0].length;
        visited = new boolean[lenX][lenY];


        for (int i = 0; i < lenX; i++) {

            boolean flag = false;
            for (int j = 0; j < lenY; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    visited[i][j] = true;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        while (!queue.isEmpty()) {

            Fragment poll = queue.poll();

            if (grid[poll.ponit[0]][poll.ponit[1]] == 1) {
                return poll.level;
            }

            for (int k = 0; k < direction.length; k++) {
                int nextX = direction[k][0] + poll.ponit[0];
                int nextY = direction[k][1] + poll.ponit[1];
                if (nextX < lenX && nextX >= 0 && nextY < lenY && nextY >= 0 && !visited[nextX][nextY]) {
                    queue.offer(new Fragment(nextX, nextY, poll.level + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return 0;

    }

    private void dfs(int[][] grid, int i, int j) {

        int lenX = grid.length;
        int lenY = grid[0].length;


        for (int k = 0; k < direction.length; k++) {
            int nextX = direction[k][0] + i;
            int nextY = direction[k][1] + j;
            if (nextX < lenX && nextX >= 0 && nextY < lenY && nextY >= 0 && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                visited[nextX][nextY] = true;
                queue.offer(new Fragment(nextX, nextY, 0));
            }

            if (nextX < lenX && nextX >= 0 && nextY < lenY && nextY >= 0 && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                dfs(grid, nextX, nextY);

            }
        }

    }
}
