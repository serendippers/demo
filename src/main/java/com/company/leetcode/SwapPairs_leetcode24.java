package com.company.leetcode;

public class SwapPairs_leetcode24 {
    class ListNode {
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

    public ListNode swapPairs(ListNode head) {

        if (head == null) return head;
        if (head.next == null) return head;

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode temp = dummyNode;

        while (temp.next != null && temp.next.next != null) {
            ListNode l = temp.next;
            ListNode r = temp.next.next;

            temp.next = r;
            l.next = r.next;
            r.next = l;
            temp = l;
        }

        return dummyNode.next;
    }
}
