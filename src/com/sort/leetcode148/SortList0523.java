package com.sort.leetcode148;

public class SortList0523 {

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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left=sortList(left);
        right=sortList(right);

        ListNode virtual = new ListNode(0);
        ListNode cur = virtual;
        while (left != null && right != null) {

            if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;

        }

        if (right != null) {
            cur.next = right;
        }

        return virtual.next;

    }
}
