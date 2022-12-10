package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉排序树中有两个错误节点,找到其
 * 1 2 3 4 5
 * case1：两处逆序 1 5 3 4 2 ，错误节点分别为第一处逆序的大数节点和第二处逆序对的小数节点
 * case2：一处逆序 1 3 2 4 5 ，错误节点即为逆序的两处节点
 */
public class Problem_10_WrongNodeRecover {
    public static TreeNode[] getErrorNodes(TreeNode head) {
        if (null == head) {
            return null;
        }
        TreeNode[] res = new TreeNode[2];
        List<TreeNode> list = new ArrayList<>();
        inOrder(head, list);
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                if (count > 0) {
                    res[1] = list.get(i + 1);
                    return res;
                }
                res[0] = list.get(i);
                res[1] = list.get(i + 1);
                count++;
            }
        }
        return res;
    }

    private static void inOrder(TreeNode head, List<TreeNode> list) {
        if (null == head) {
            return;
        }
        inOrder(head.left, list);
        list.add(head);
        inOrder(head.right, list);
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
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(8);
        head.left.left.left = new TreeNode(1);
        printTree(head);

        //2 5
        head.val = 2;
        head.left.left.val = 5;
        TreeNode[] res = getErrorNodes(head);
        for (TreeNode re : res) {
            System.out.println(re.val);
        }

        //3 5
        head.val = 5;
        head.left.left.val = 2;
        head.val = 3;
        head.left.val = 5;
        res = getErrorNodes(head);
        for (TreeNode re : res) {
            System.out.println(re.val);
        }
    }
}
