package com.sort.leetcode147;

public class InsertionSortList0619 {

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

    public ListNode insertionSortList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }


        ListNode vis = new ListNode(0);
        vis.next = head;

        ListNode sortEnd = head;
        ListNode cur = head.next;

        while (cur != null) {

            if (cur.val >= sortEnd.val) {
                sortEnd = cur;
                cur = cur.next;
            } else {

                ListNode check = vis.next;
                ListNode pre = vis;
                while (check.val < cur.val) {
                    pre = check;
                    check = check.next;
                }
                sortEnd.next = cur.next;
                pre.next = cur;
                cur.next = check;
                cur = sortEnd.next;
            }


        }

        return vis.next;


    }
}
