package com.sort.leetcode148;

public class SortList0620 {

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

    private ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow;

        ListNode left = head;

        ListNode right = mid.next;

        mid.next = null;

        ListNode leftNode = mergeSort(left);
        ListNode rightNode = mergeSort(right);

        ListNode vis = new ListNode(0);
        ListNode cur = vis;


        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                cur.next = leftNode;
                leftNode = leftNode.next;
            } else {
                cur.next = rightNode;
                rightNode = rightNode.next;
            }

            cur = cur.next;

        }

        while (leftNode != null) {
            cur.next = leftNode;
            leftNode = leftNode.next;
            cur = cur.next;
        }

        while (rightNode != null) {
            cur.next = rightNode;
            rightNode = rightNode.next;
            cur = cur.next;
        }

        return vis.next;
    }
}
