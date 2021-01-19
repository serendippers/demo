package com.company.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (arr.length == k ) return arr;
        if (k == 0) return new int[]{};

        Queue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> Integer.compare(o2, o1));

        for (int val : arr) {
            if (heap.isEmpty() || heap.size() < k || heap.peek() > val) {
                heap.offer(val);
            }

            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (index < k && !heap.isEmpty()) {
            res[index++] = heap.poll();
        }
        return res;
    }
}
