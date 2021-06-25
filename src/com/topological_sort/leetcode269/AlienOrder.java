package com.topological_sort.leetcode269;

import java.util.*;

public class AlienOrder {

    public String alienOrder(String[] words) {
        int len = words.length;

        if (len == 1) {
            return words[0];
        }
        Map<Character, Set<Character>> adjMap = new HashMap<>();

        int[] degree = new int[26];


        for (int i = 0; i < degree.length; i++) {
            degree[i] = -1;
        }

        for (int i = 0; i < len - 1; i++) {

            int firstLen = words[i].length();
            int secondLen = words[i + 1].length();
            int index = 0;
            while (index < firstLen && index < secondLen) {
                if (words[i].charAt(index) == words[i + 1].charAt(index)) {
                    index++;
                    continue;
                } else {
                    char first = words[i].charAt(index);
                    char second = words[i + 1].charAt(index);
                    if (degree[first - 'a'] == -1) {
                        degree[first - 'a'] = 0;
                    }

                    if (degree[second - 'a'] == -1) {
                        degree[second - 'a'] = 0;
                    }

                    Set<Character> set = adjMap.getOrDefault(first, new HashSet<>());
                    if (!set.contains(second)) {
                        set.add(second);
                        degree[second - 'a']++;
                        adjMap.put(first, set);
                    }
                    break;
                }

            }

            if (index < firstLen && index >= secondLen) {
                return "";
            }

        }
        int count = 0;
        Queue<Character> queue = new LinkedList();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] != -1) {
                count++;
            }

            if (degree[i] == 0) {
                queue.offer((char) (i + 'a'));
            }

        }


        StringBuilder strB = new StringBuilder();
        int index = 0;
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            index++;
            strB.append(poll);
            Set<Character> set = adjMap.get(poll);
            if (set != null) {
                for (Character node : set) {
                    degree[node - 'a']--;
                    if (degree[node - 'a'] == 0) {
                        queue.offer(node);
                    }

                }
            }
        }

        if (count != index) {
            return "";
        } else {
            return strB.toString();
        }
    }
}