package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

/**
 * 最大二叉搜索子树
 */
public class Problem_07_BiggestSubBSTInTree {
    public static TreeNode biggestSubBST(TreeNode head) {
        //0存最大搜索二叉子树的节点个数，1存最小value值，2存最大value值
        int[] record = new int[3];
        return postOrder(head, record);
    }

    private static TreeNode postOrder(TreeNode head, int[] record) {
        //空直接返回
        if (null == head) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        //后序遍历左右最大子树的节点数，最小值，最大值
        TreeNode lMSubBST = postOrder(head.left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        TreeNode rMSubBST = postOrder(head.right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        //若跟节点与左右最大子树能拼成更大的BST，返回跟节点
        if (head.left == lMSubBST && head.right == rMSubBST && head.val > lMax && head.val < rMin) {
            record[0] = lSize + rSize + 1;
            record[1] = Math.min(lMin,head.val);
            record[2] = Math.max(rMax,head.val);
            return head;
        }
        //其他情况下，返回节点更多的子树
        if (lSize > rSize) {
            record[0] = lSize;
            record[1] = lMax;
            record[2] = lMax;
        }
        return lSize > rSize ? lMSubBST : rMSubBST;
    }

    // for test -- print tree
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(1);
        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(3);
        head.right = new TreeNode(12);
        head.right.left = new TreeNode(10);
        head.right.left.left = new TreeNode(4);
        head.right.left.left.left = new TreeNode(2);
        head.right.left.left.right = new TreeNode(5);
        head.right.left.right = new TreeNode(14);
        head.right.left.right.left = new TreeNode(11);
        head.right.left.right.right = new TreeNode(15);
        head.right.right = new TreeNode(13);
        head.right.right.left = new TreeNode(20);
        head.right.right.right = new TreeNode(16);

        printTree(head);
        TreeNode bst = biggestSubBST(head);
        printTree(bst);
    }
}
