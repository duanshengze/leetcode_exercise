package com.sort.leetcode148;

import java.util.List;

public class SortList0711 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {



        return mergeSort(head);

    }

    private ListNode mergeSort(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }
        ListNode fast = node.next.next;
        ListNode slow = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        ListNode left = node;

        ListNode right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);


        ListNode pre = new ListNode();
        ListNode cur = pre;
        ListNode curLeft = left;

        ListNode curRight = right;
        while (curLeft != null && curRight != null) {

            if (curLeft.val < curRight.val) {
                cur.next = curLeft;
                curLeft = curLeft.next;

            } else {
                cur.next = curRight;
                curRight = curRight.next;
            }
            cur = cur.next;
        }

        if (curLeft != null) {
            cur.next = curLeft;
        }

        if (curRight != null) {
            cur.next = curRight;
        }

        return pre.next;
    }
}
