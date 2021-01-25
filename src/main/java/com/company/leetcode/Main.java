package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        //遍历二叉树
//        PreorderTraversal preorderTraversal = new PreorderTraversal(true);
//        preorderTraversal.play();

//        ReverseWords_offer58 reverseWordsOffer58 = new ReverseWords_offer58();
//        System.out.println(reverseWordsOffer58.reverseWords("the sky is blue"));

//        MinPathSum_leetcode64 test = new MinPathSum_leetcode64();
//        test.test();

        LRUCache_leetcode146 lru = new LRUCache_leetcode146(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        lru.get(2);

    }
}
