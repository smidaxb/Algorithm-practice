package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树层次遍历，每层正、逆序遍历
 */
public class Problem_09_PrintBinaryTreeByLevelAndZigZag {


    private static void printByLevel(TreeNode head) {
        if (null == head) {
            return;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        int len = 1;
        int nextLen = 0;
        que.addLast(head);
        while (!que.isEmpty()) {
            TreeNode node = que.pollFirst();
            len--;
            System.out.print("  " + node.val);
            if (null != node.left) {
                que.addLast(node.left);
                nextLen++;
            }
            if (null != node.right) {
                que.addLast(node.right);
                nextLen++;
            }
            if (len == 0) {
                System.out.println();
                len = nextLen;
                nextLen = 0;
            }
        }
    }

    private static void printByZigZag(TreeNode head) {
        if (null == head) {
            return;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        int len = 1;
        int nextLen = 0;
        int level = 1;
        LinkedList<TreeNode> arr = new LinkedList<>();
        que.addLast(head);
        while (!que.isEmpty()) {
            TreeNode node = que.pollFirst();
            len--;
            arr.add(node);
            if (null != node.left) {
                que.addLast(node.left);
                nextLen++;
            }
            if (null != node.right) {
                que.addLast(node.right);
                nextLen++;
            }
            if (len == 0) {
                if (level % 2 == 1) {
                    while (!arr.isEmpty()) {
                        System.out.print("  " + arr.pollFirst().val);
                    }
                } else {
                    while (!arr.isEmpty()) {
                        System.out.print("  " + arr.pollLast().val);
                    }
                }
                System.out.println();
                len = nextLen;
                nextLen = 0;
                level++;
            }
        }
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
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        head.right.left.left = new TreeNode(7);
        head.right.left.right = new TreeNode(8);

        printTree(head);

        System.out.println("===============");
        printByLevel(head);

        System.out.println("===============");
        printByZigZag(head);

    }


}
