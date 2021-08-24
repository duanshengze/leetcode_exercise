package com.topological_sort.leetcode269;

import java.util.*;

public class AlienOrder0711 {

    public String alienOrder(String[] words) {

        int len = words.length;

        Set<Character> nodes = new HashSet<>();
        for (String word : words) {

            for (int i = 0; i < word.length(); i++) {

                nodes.add(word.charAt(i));
            }

        }
        Map<Character, Set<Character>> adjM = new HashMap<>();
        int[] degree = new int[26];

        for (int i = 0; i < len - 1; i++) {

            String before = words[i];
            String after = words[i + 1];

            int bf = 0;
            int af = 0;

            boolean flag = false;
            while (bf < before.length() && af < after.length()) {

                if (before.charAt(bf) != after.charAt(af)) {
                    flag = true;
                    Set<Character> subs = adjM.get(before.charAt(bf));
                    if (subs == null) {
                        subs = new HashSet<>();
                        subs.add(after.charAt(af));
                        adjM.put(before.charAt(bf), subs);
                        degree[after.charAt(af) - 'a']++;
                    } else if (!subs.contains(after.charAt(af))) {
                        subs.add(after.charAt(af));
                        degree[after.charAt(af) - 'a']++;
                    }

                    break;
                }
                bf++;
                af++;
            }

            if (!flag && bf < before.length()) {
                return "";
            }

        }

        Queue<Character> queue = new LinkedList<>();
        for (Character node : nodes) {
            if (degree[node - 'a'] == 0) {
                queue.add(node);
            }
        }

        StringBuilder strB = new StringBuilder();
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            strB.append(poll);
            Set<Character> subs = adjM.get(poll);

            if (subs != null) {

                for (Character node : subs) {
                    degree[node - 'a']--;
                    if (degree[node - 'a'] == 0) {
                        queue.offer(node);
                    }
                }
            }
        }

        if (nodes.size() != strB.length()) {
            return "";
        } else {
            return strB.toString();
        }

    }


}
