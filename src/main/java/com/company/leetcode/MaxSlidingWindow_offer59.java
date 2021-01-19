package com.company.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxSlidingWindow_offer59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};

        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i > k-1 && deque.peekFirst() == nums[i -k]) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.offer(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = deque.peekFirst();
            }
        }
        return res;
    }
}
