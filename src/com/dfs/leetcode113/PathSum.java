package com.dfs.leetcode113;

import java.util.ArrayList;
import java.util.List;

public class PathSum {


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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> curList = new ArrayList<>();

        int curSum = 0;
        dfs(root, curList, curSum, targetSum, ans);

        return ans;
    }

    private void dfs(TreeNode root, List<Integer> preList, int preSum, int targetSum, List<List<Integer>> ans) {


        if (root == null) {
            return;
        }

        int curSum = preSum + root.val;
        preList.add(root.val);
        if (curSum == targetSum && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(preList));
        }

        dfs(root.left, preList, curSum, targetSum, ans);
        dfs(root.right, preList, curSum, targetSum, ans);

        preList.remove(preList.size() - 1);

    }
}
