package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Yanbo {



    public static void main(String[] args) {

        HashMap hash = new HashMap<String, String>();
    }

    class Node {
        Node node;
    }

    public static boolean doSome(Node head1, Node head2) {

        Set<Node> nodes = new HashSet<>();
        while (head1!=null) {
            nodes.add(head1);
            head1 = head1.node;
        }

        while (head2!=null) {
            if (nodes.contains(head2)) {
                return true;
            }
            head2 = head2.node;
        }
        return false;
    }


}
