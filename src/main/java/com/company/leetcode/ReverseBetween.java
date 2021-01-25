package com.company.leetcode;

public class ReverseBetween {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



    public ListNode reverseBetween(ListNode head) {
        if (head == null) return null;
        ListNode l = head;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }
        ListNode index = head;
        ListNode temp = null;
        while (index != end) {
            index = index.next;
            temp = end.next;
            end.next = l;
            l.next = temp;
            l = index;
        }
        return end;
    }
}
