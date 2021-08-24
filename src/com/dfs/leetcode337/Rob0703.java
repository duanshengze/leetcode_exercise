package com.dfs.leetcode337;

import java.util.HashMap;
import java.util.Map;

public class Rob0703 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.get(root) != null) {
            return cache.get(root);
        }


        int rob = root.val;


        if (root.left != null) {
            rob += rob(root.left.left);
            rob += rob(root.left.right);
        }

        if (root.right != null) {
            rob += rob(root.right.left);
            rob += rob(root.right.right);
        }

        int noRob = 0;

        noRob += rob(root.right);
        noRob += rob(root.left);

        int max = Math.max(noRob, rob);

        cache.put(root, max);
        return max;
    }
}
