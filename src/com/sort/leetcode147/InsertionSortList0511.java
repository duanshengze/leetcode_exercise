package com.sort.leetcode147;

import java.util.List;

public class InsertionSortList0511 {

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

        ListNode virtualNode = new ListNode(0);
        virtualNode.next = head;


        ListNode sortEnd = head;
        ListNode curr = sortEnd.next;

        while (curr != null) {

            if (sortEnd.val <= curr.val) {
                sortEnd = curr;
            } else {
                ListNode startPre = virtualNode;
                ListNode start = virtualNode.next;

                while (start.val <=curr.val) {
                    startPre = start;
                    start = startPre.next;
                }
                sortEnd.next=curr.next;
                startPre.next=curr;
                curr.next=start;
            }
            curr = sortEnd.next;
        }

        return virtualNode.next;

    }
}
