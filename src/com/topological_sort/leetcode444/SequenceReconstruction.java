package com.topological_sort.leetcode444;



import java.util.*;

public class SequenceReconstruction {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {


        Set<Integer> nodes = new HashSet<>();

        for (List<Integer> seq : seqs) {
            for (Integer node : seq) {
                nodes.add(node);
            }
        }

        if (org.length != nodes.size()) {
            return false;
        }

        Map<Integer, Set<Integer>> adjM = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                int before = seq.get(i);
                int after = seq.get(i + 1);

                Set<Integer> set = adjM.get(before);

                if (set == null) {
                    set = new HashSet<>();
                    set.add(after);
                    adjM.put(before, set);
                    int count = degree.getOrDefault(after, 0);
                    degree.put(after, count + 1);
                } else if (!set.contains(after)) {
                    int count = degree.getOrDefault(after, 0);
                    degree.put(after, count + 1);
                    set.add(after);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer node : nodes) {
            int count = degree.getOrDefault(node, 0);

            if (count == 0) {
                queue.add(node);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {

            if (queue.size() > 1 || queue.peek() != org[index++]) {
                return false;
            }
            Integer poll = queue.poll();

            Set<Integer> set = adjM.get(poll);
            if (set != null) {
                for (Integer node : set) {
                    int count = degree.get(node);
                    if (count - 1 == 0) {
                        queue.offer(node);

                    }
                    degree.put(node, count - 1);
                }

            }

        }
        if (index != nodes.size()) {
            return false;
        }
        return true;
    }
}
