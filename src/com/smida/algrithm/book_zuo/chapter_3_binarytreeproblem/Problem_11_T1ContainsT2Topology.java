package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

/**
 * T1是否包含T2的拓扑结构
 */
public class Problem_11_T1ContainsT2Topology {
    public static boolean judgeContains(TreeNode t1, TreeNode t2) {
        if (null == t1) {
            return false;
        } else if (null == t2) {
            return true;
        }
        return contain(t1, t2) || contain(t1.left, t2) || contain(t1.right, t2);
    }

    private static boolean contain(TreeNode t1, TreeNode t2) {
        if (null == t2) {
            return true;
        }
        if (null == t1) {
            return false;
        }
        return t1.val == t2.val && contain(t1.left, t2.left) && contain(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        t1.left.left.left = new TreeNode(8);
        t1.left.left.right = new TreeNode(9);
        t1.left.right.left = new TreeNode(10);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);
        t2.left.left = new TreeNode(8);
        t2.right = new TreeNode(5);

        System.out.println(judgeContains(t1, t2));
        System.out.println(judgeContains(t1, new TreeNode(1)));

    }
}
