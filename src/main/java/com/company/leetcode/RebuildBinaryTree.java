package com.company.leetcode;


import java.util.HashMap;
import java.util.Map;

public class RebuildBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) return null;

        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }


        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, inorderMap);
    }


    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int l, int r, Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        if (preEnd == preStart) {
            return node;
        } else {
            int index = inorderMap.get(preorder[preStart]);
            int leftNodes = index - l, rightNodes = r - index;
            node.left = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, l, index-1, inorderMap);
            node.right = buildTree(preorder, preEnd - rightNodes + 1, preEnd, inorder, index + 1, r, inorderMap);
        }
        return node;
    }

}
