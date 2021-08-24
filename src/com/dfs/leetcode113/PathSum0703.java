package com.dfs.leetcode113;

import java.util.ArrayList;
import java.util.List;

public class PathSum0703 {

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


    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


        dfs(root, 0, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int preSum, int targetSum) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        int curSum = preSum + root.val;
        if (curSum == targetSum && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(list));
        }

        dfs(root.left, curSum, targetSum);
        dfs(root.right, curSum, targetSum);
        list.remove(list.size() - 1);
    }
}
