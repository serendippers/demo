package com.company.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache_leetcode146 {

    Map<Integer, Node> cacheMap = null;
    int capacity = 0;
    PriorityQueue<Node> queue = null;
    class Node {
        int key;
        int count;
        int val;

        public Node(int key,int val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }

    }

    public LRUCache_leetcode146(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        queue = new PriorityQueue<>(capacity, (n1, n2) -> n1.count - n2.count);

    }

    public int get(int key) {
        int res = -1;
        Node node = cacheMap.getOrDefault(key, null);
        if (node != null) {
            node.count++;
            res = node.val;
        }
        return res;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (queue.size() >= capacity) {
            Node oldNode = queue.poll();
            cacheMap.remove(oldNode.key);
        }
        cacheMap.put(key, node);
        queue.offer(node);
    }
}
