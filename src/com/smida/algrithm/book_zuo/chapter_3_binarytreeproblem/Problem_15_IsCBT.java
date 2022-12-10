package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 判断是否完全二叉树
 * 按层遍历；若某个节点有右子树但左子树为空，返回false；若某个节点开始右子树为空，则接下来的节点必须全为叶子节点
 */
public class Problem_15_IsCBT {

    private static boolean isCBT(TreeNode head) {
        if (null == head) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        boolean leafBegin = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null != node.right && null == node.left) {
                return false;
            }
            if (null != node.left) {
                queue.add(node.left);
            }
            if (null != node.right) {
                queue.add(node.right);
            }
            if (leafBegin && (null != node.left || null != node.right)) {
                return false;
            }
            if (null == node.right) {
                leafBegin = true;
            }
        }
        return true;
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
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = null;
//        head.left.right = new TreeNode(3);
        head.right.right = null;
        head.right.left = new TreeNode(5);

        printTree(head);
        System.out.println(isCBT(head));

    }

}
