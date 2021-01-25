package com.company.leetcode;

public class AddTwoNumbers_leetcode2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        boolean status = false;
        ListNode node = head;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            int val2 = 0;
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            val1 = val2 + val1;
            if (status) {
                val1 += 1;
                status = false;
            }
            if (val1 > 9) {
                val1 = val1 % 10;
                status = true;
            }
            node.next = new ListNode(val1);
            node = node.next;

        }
        if (status) {
            node.next = new ListNode(1);
        }
        return head.next;
    }
}
