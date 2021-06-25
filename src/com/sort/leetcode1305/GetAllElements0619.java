package com.sort.leetcode1305;

import java.util.ArrayList;
import java.util.List;

public class GetAllElements0619 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> ans = new ArrayList<>();
        int[] arr1 = new int[5000];
        int[] arr2 = new int[5000];

        int len1 = midOrder(root1, arr1, 0);

        int len2 = midOrder(root2, arr2, 0);

        int left = 0;
        int right = 0;

        while (left < len1 && right < len2) {

            if (arr1[left] < arr2[right]) {
                ans.add(arr1[left++]);
            } else {
                ans.add(arr2[right++]);
            }

        }

        while (left < len1) {
            ans.add(arr1[left++]);
        }

        while (right < len2) {
            ans.add(arr2[right++]);
        }
        return ans;
    }

    private int midOrder(TreeNode root, int[] arr, int start) {

        if (root == null) {
            return start;
        }

        int len = midOrder(root.left, arr, start);
        arr[len++] = root.val;
        return midOrder(root.right, arr, len);
    }
}
