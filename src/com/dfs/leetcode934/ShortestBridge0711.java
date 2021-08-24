package com.dfs.leetcode934;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestBridge0711 {


    private boolean[][] visited;

    private List<int[]> list;

    private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private class Fagment {
        private int x;
        private int y;
        private int level;

        public Fagment(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    public int shortestBridge(int[][] grid) {

        int lenX = grid.length;
        int lenY = grid[0].length;

        visited = new boolean[lenX][lenY];

        list = new ArrayList<>();

        for (int i = 0; i < lenX; i++) {
            boolean flag = false;
            for (int j = 0; j < lenY; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    visited[i][j] = true;
                    dfs(grid, i, j);
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        Queue<Fagment> queue = new LinkedList<>();

        for (int[] point : list) {
            for (int k = 0; k < direction.length; k++) {
                int nextX = direction[k][0] + point[0];
                int nextY = direction[k][1] + point[1];
                if (nextX >= 0 && nextX < lenX && nextY >= 0 && nextY < lenY && grid[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Fagment(nextX, nextY, 1));
                }

            }

        }
        while (!queue.isEmpty()) {
            Fagment poll = queue.poll();
            if (grid[poll.x][poll.y] == 1) {
                return poll.level;
            }
            for (int k = 0; k < direction.length; k++) {
                int nextX = direction[k][0] + poll.x;
                int nextY = direction[k][1] + poll.y;
                if (nextX >= 0 && nextX < lenX && nextY >= 0 && nextY < lenY && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Fagment(nextX, nextY, poll.level + 1));
                }

            }


        }
        return 1;
    }

    private void dfs(int[][] grid, int i, int j) {
        int lenX = grid.length;
        int lenY = grid[0].length;
        list.add(new int[]{i, j});

        for (int k = 0; k < direction.length; k++) {
            int nextX = direction[k][0] + i;
            int nextY = direction[k][1] + j;
            if (nextX >= 0 && nextX < lenX && nextY >= 0 && nextY < lenY && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                dfs(grid, nextX, nextY);
            }

        }
    }
}
