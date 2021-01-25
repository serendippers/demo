package com.company.leetcode;

public class OddEvenList_leetcode328 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next == null) return head;

        ListNode oldHead = head;
        ListNode evenHead = head.next;
        ListNode index = evenHead;
        while (index.next != null && index.next.next!=null) {
            oldHead.next = index.next;
            oldHead = oldHead.next;
            index.next = index.next.next;
            index = index.next;
        }

        oldHead.next = evenHead;
        return head;
    }
}
