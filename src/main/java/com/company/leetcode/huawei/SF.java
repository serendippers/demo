package com.company.leetcode.huawei;

public class SF {

//    private static SF sf = new SF();
//
//    private SF(){};
//
//    public SF getSf() {
//        return  sf;
//    }

//    private SF sf = null;
//
//    private SF(){}
//
//
//    public  SF getSf() {
//        if (sf == null) {
//            synchronized (this) {
//                this.sf = new SF();
//            }
//        }
//        return sf;
//    }


    static class Node {
        Node left;
        Node right;
        int val;

    }

    public static void main(String[] args) {
        Node root = new Node();
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

        show(root);
    }

    public static void show(Node root) {
        if(root ==null) {
            return;
        }

        show(root.left);

        show(root.right);
        System.out.println(root.val);
    }
}
