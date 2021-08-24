package com.topological_sort.leetcode444;

import java.util.*;

public class SequenceReconstruction0711 {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        Set<Integer> nodes = new HashSet<>();
        for (List<Integer> seq : seqs) {
            for (Integer node : seq) {
                nodes.add(node);
            }
        }

        if (nodes.size() != org.length) {
            return false;
        }
        Map<Integer, List<Integer>> adjM = new HashMap<>();

        int[] degree = new int[10001];

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {

                int before = seq.get(i);
                int after = seq.get(i + 1);
                List<Integer> list = adjM.get(before);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(after);
                    degree[after]++;
                    adjM.put(before,list);
                } else if (!list.contains(after)) {
                    list.add(after);
                    degree[after]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (Integer node : nodes) {
            if (degree[node] == 0) {
                queue.add(node);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {

            if (queue.size() != 1 || queue.peek() != org[index]) {
                return false;
            }
            int poll = queue.poll();
            index++;

            List<Integer> list = adjM.get(poll);
            if (list != null) {
                for (Integer node : list) {
                    degree[node]--;
                    if (degree[node] == 0) {
                        queue.add(node);
                    }
                }
            }
        }

        if (index != nodes.size()) {
            return false;
        } else {
            return true;
        }

    }
}
