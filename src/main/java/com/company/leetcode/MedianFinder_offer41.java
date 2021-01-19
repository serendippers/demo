package com.company.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder_offer41 {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder_offer41() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    }

    public void addNum(int num) {
        if (minHeap.size() != maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size() != minHeap.size() ? maxHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
