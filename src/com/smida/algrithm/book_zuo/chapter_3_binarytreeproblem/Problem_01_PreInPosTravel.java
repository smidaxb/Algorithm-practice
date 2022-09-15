package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

import java.util.Stack;

/**
 * 二叉树前中后序遍历（非递归）
 */
public class Problem_01_PreInPosTravel {
    //用栈，1头入；2出；3右左非空入；循环23
    public static void preOrder(TreeNode head) {
        if (null == head) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        System.out.println("非递归前序遍历：");
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print("   " + node.value);
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    //用栈，1栈不空或当前不空进循环 2当前不空当前入栈，当前指向左子树；当前为空时令当前指向出栈元素，打印，当前指向右子树
    public static void inOrder(TreeNode head) {
        if (null == head) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        System.out.println("非递归中序遍历：");
        TreeNode cur = head;
        while (null != cur || !stack.isEmpty()) {
            if (null != cur) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print("   " + cur.value);
                cur = cur.right;
            }
        }
        System.out.println();
    }

    //用俩栈，1头入栈一，2出栈一，3左右孩子非空陆续入栈一，4栈一出栈马上入栈二，23循环，最后批量打印栈2
    public static void postOrder(TreeNode head) {
        if (null == head) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        System.out.println("非递归后序遍历：");
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (null != node.left) {
                stack1.push(node.left);
            }
            if (null != node.right) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print("   " + stack2.pop().value);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

        preOrder(head);
        inOrder(head);
        postOrder(head);
    }
}
