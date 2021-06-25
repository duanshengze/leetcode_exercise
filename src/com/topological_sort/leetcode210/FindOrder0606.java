package com.topological_sort.leetcode210;

import java.util.*;

public class FindOrder0606 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int lenX = prerequisites.length;

        int[] degree = new int[numCourses];
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();


        for (int i = 0; i < lenX; i++) {
            if (adjMap.containsKey(prerequisites[i][1])) {
                Set<Integer> nodes = adjMap.get(prerequisites[i][1]);
                nodes.add(prerequisites[i][0]);

            } else {
                Set<Integer> set = new HashSet<>();
                set.add((prerequisites[i][0]));
                adjMap.put(prerequisites[i][1], set);
            }
            degree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ans[index++] = poll;
            Set<Integer> set = adjMap.get(poll);

            if (set == null) {
                continue;
            }
            for (Integer node : set) {
                degree[node]--;

                if (degree[node] == 0) {
                    queue.offer(node);
                }
            }
        }

        if (index < numCourses) {
            return new int[]{};
        }

        return ans;

    }
}
