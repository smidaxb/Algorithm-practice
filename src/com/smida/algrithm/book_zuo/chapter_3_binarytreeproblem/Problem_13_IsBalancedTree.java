package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

public class Problem_13_IsBalancedTree {
    //标准答案
    public static boolean isBalance(TreeNode head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    //My
    public static boolean isBalanceMy(TreeNode head) {
        if (null == head) {
            return true;
        }
        return isBalanceMyNull(head);
    }

    private static boolean isBalanceMyNull(TreeNode head) {
        if (null == head) {
            return true;
        }
        int hc = Math.abs(myGetHigh(head.left) - myGetHigh(head.right));
        return hc <= 1 && isBalanceMyNull(head.left) && isBalanceMyNull(head.right);
    }

    private static int myGetHigh(TreeNode head) {
        if (null == head) {
            return 0;
        }
        int lh = myGetHigh(head.left) + 1;
        int rh = myGetHigh(head.right) + 1;
        return lh > rh ? lh : rh;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);

        System.out.println(isBalance(head));
        System.out.println(isBalanceMy(head));

    }

}
