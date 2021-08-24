package com.topological_sort.leetcode210;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindOrder0711 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] degree = new int[numCourses];

        Set<Integer>[] adjM = new HashSet[numCourses];

        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < prerequisites[i].length - 1; j++) {
                int before = prerequisites[i][j];
                int after = prerequisites[i][j + 1];

                if (adjM[after] == null) {
                    adjM[after] = new HashSet<>();
                    adjM[after].add(before);
                    degree[before]++;
                } else if (!adjM[after].contains(before)) {
                    adjM[after].add(before);
                    degree[before]++;
                }

            }


        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ans[index++] = poll;

            if (adjM[poll] != null) {
                for (Integer node : adjM[poll]) {
                    degree[node]--;
                    if (degree[node] == 0) {
                        queue.offer(node);
                    }
                }
            }
        }

        if (index != numCourses) {
            return new int[]{};
        } else {
            return ans;
        }

    }
}
