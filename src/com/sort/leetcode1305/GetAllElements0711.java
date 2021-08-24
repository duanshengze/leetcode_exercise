package com.sort.leetcode1305;

import java.util.ArrayList;
import java.util.List;

public class GetAllElements0711 {


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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        dfs(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        dfs(root2, list2);

        int left = 0;
        int right = 0;
        List<Integer> ans = new ArrayList<>();
        while (left < list1.size() && right < list2.size()) {
            if (list1.get(left) < list2.get(right)) {
                ans.add(list1.get(left++));
            } else {
                ans.add(list2.get(right++));
            }
        }

        while (left < list1.size() ) {
                ans.add(list1.get(left++));

        }


        while (right < list2.size() ) {
            ans.add(list2.get(right++));

        }

        return ans;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
