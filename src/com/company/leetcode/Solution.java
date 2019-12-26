package com.company.leetcode;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tempNode = res;
        boolean status = false;
        int temp = 0;
        while (null != l1|| null != l2 || status) {
            temp = status ? 1 : 0;
            if (null != l1) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                temp += l2.val;
                l2 = l2.next;
            }
            if (temp > 9) {
                status = true;
                tempNode.val = temp - 10;

            } else {
                status = false;
                tempNode.val = temp;
            }
            if(l1!=null || l2!=null || status){
                tempNode.next = new ListNode(0);
            }
            tempNode = tempNode.next;
        }
        return res;
    }
}
