package com.company.leetcode;

public class ReverseKGroup_leetcode25 {

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


    public ListNode reverseKGroup(ListNode head, int k) {

        if(k<=1) return head;

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode temp = dummyNode;

        while (true) {
            ListNode l = temp.next;
            ListNode r = temp.next;

            r = getRightNode(r, k);
            if (r == null) {
                return dummyNode.next;
            }
            ListNode index = null;
            for (int i = 0; i < k-1; i++) {
                if (i==0) index = l;
                temp.next = l.next;
                l.next = r.next;
                r.next = l;
                l = temp.next;
            }
            temp = index;
        }
    }

    public ListNode getRightNode(ListNode node, int k) {
        for (int i = 0; i < k-1; i++) {
            if (node == null) return null;
            node = node.next;
        }
        return node;
    }
}
