package com.company.leetcode;

import com.company.leetcode.huawei.SF;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class PreorderTraversal {

    private Node root = null;

    class Node {
        Node left;
        Node right;
        int val;
    }

    public PreorderTraversal() {
    }

    public PreorderTraversal(boolean initStatus) {
        Node root = new Node();
        this.root = root;
        root.val = 1;
        Node node = new Node();
        node.val = 2;
        root.left = node;

        node = new Node();
        node.val = 3;
        root.right = node;

        node = new Node();
        node.val = 4;
        root.left.left = node;

        node = new Node();
        node.val = 5;
        root.left.right = node;

        node = new Node();
        node.val = 7;
        root.left.right.left = node;

        node = new Node();
        node.val = 8;
        root.left.right.right = node;

        node = new Node();
        node.val = 6;
        root.right.right = node;
    }


    //简单的递归
    private List<Integer> recursionFunc(Node node, List<Integer> res) {
        if (null == node) {
            return res;
        }
        //前序遍历
        res.add(node.val);
        recursionFunc(node.left, res);
        //中序遍历
        //res.add(node.val);
        recursionFunc(node.right, res);
        //后序遍历
        //res.add(node.val);

        return res;
    }

    //不用递归来实现前序遍历
    //利用栈
    private List<Integer> stackFunc(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }

        Deque<Node> stack = new LinkedList<>();

        //前序遍历
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        //中序遍历
        /*while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }*/


        return res;
    }

    public void play() {
        List<Integer> list = stackFunc(this.root);
        System.out.println(list.size());
        list.forEach(System.out::print);
    }
}
