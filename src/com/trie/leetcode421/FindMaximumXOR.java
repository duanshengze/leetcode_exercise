package com.trie.leetcode421;

public class FindMaximumXOR {


    public int findMaximumXOR(int[] nums) {
        int len = nums.length;
        Trie trie = new Trie();
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            trie.insert(nums[i]);
            max = Math.max(trie.getBitMax(nums[i + 1]), max);
        }
        return max;

    }


    private class Trie {
        private Trie[] children = new Trie[2];

        public Trie() {
        }

        public void insert(int num) {

            Trie cur = this;

            for (int i = 30; i >= 0; i--) {

                int bit = getBit(num, i);
                Trie node = cur.children[bit];
                if (node == null) {
                    node = new Trie();
                    cur.children[bit] = node;
                }
                cur = node;
            }
        }

        public int getBitMax(int num) {
            Trie cur = this;

            int ans = 0;
            for (int i = 30; i >= 0; i--) {

                int bit = getBit(num, i);
                bit ^= 1;
                Trie node = cur.children[bit];
                if (node == null) {
                    bit^=1;
                    node = cur.children[bit];
                    ans = ans * 2;
                } else {
                    ans = ans * 2 + 1;
                }
                cur = node;
            }
            return ans;
        }


        private int getBit(int num, int k) {
            return num >> k & 1;
        }
    }
}
