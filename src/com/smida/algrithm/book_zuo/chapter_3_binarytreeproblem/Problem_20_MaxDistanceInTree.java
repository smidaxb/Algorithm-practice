package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

/**
 * 二叉树节点间最大距离(连接路线上共有几个节点)
 * 如 1
 * 2    3
 * 最大距离为2-3，为3
 * <p>
 * 解析：最大距离为左子树最大距离lmax、右子树最大距离rmax、左子树树高+右子树树高+1三个值中较大的那个
 * 用后续遍历分别求
 */
public class Problem_20_MaxDistanceInTree {
    //标准
    public static int maxDistance(TreeNode head) {
        int[] record = new int[1];
        return posOrder(head, record);
    }

    public static int posOrder(TreeNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left, record);
        int maxfromLeft = record[0];
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];
        int curTreeNodeMax = maxfromLeft + maxFromRight + 1;
        record[0] = Math.max(maxfromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), curTreeNodeMax);
    }


    //My
    public static int maxDistanceMy(TreeNode head) {
        if (null == head) {
            return 0;
        }
        int[] record = new int[1];
        return posOrderMy(head, record);
    }

    private static int posOrderMy(TreeNode head, int[] record) {
        if (null == head) {
            record[0] = 0;
            return 0;
        }
        int lmax = posOrderMy(head.left, record);
        int lh = record[0];
        int rmax = posOrderMy(head.right, record);
        int rh = record[0];
        int hmax = lh + rh + 1;
        //record[0]记录树高
        record[0] = Math.max(lh, rh) + 1;
        return Math.max(Math.max(lmax, rmax), hmax);
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(3);
        head1.left.left = new TreeNode(4);
        head1.left.right = new TreeNode(5);
        head1.right.left = new TreeNode(6);
        head1.right.right = new TreeNode(7);
        head1.left.left.left = new TreeNode(8);
        head1.right.left.right = new TreeNode(9);
        System.out.println(maxDistance(head1));
        System.out.println(maxDistanceMy(head1));

        TreeNode head2 = new TreeNode(1);
        head2.left = new TreeNode(2);
        head2.right = new TreeNode(3);
        head2.right.left = new TreeNode(4);
        head2.right.right = new TreeNode(5);
        head2.right.left.left = new TreeNode(6);
        head2.right.right.right = new TreeNode(7);
        head2.right.left.left.left = new TreeNode(8);
        head2.right.right.right.right = new TreeNode(9);
        System.out.println(maxDistance(head2));
        System.out.println(maxDistanceMy(head2));

    }

}
