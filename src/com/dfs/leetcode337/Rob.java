package com.dfs.leetcode337;

import java.util.HashMap;
import java.util.Map;

public class Rob {

    private class TreeNode {
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


    Map<TreeNode, Integer> visited = new HashMap();

    public int rob(TreeNode root) {


        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (visited.get(root) != null) {
            return visited.get(root);
        }





        int noRob =0;

        noRob += dfs(root.left);
        noRob += dfs(root.right);




        int rob = root.val;
        if (root.left != null) {
            rob += dfs(root.left.left);
            rob += dfs(root.left.right);
        }

        if (root.right != null) {
            rob += dfs(root.right.left);
            rob += dfs(root.right.right);
        }


        int max = Math.max(rob, noRob);

        visited.put(root, max);
        return max;
    }
}
