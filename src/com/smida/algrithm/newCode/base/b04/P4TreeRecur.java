package com.smida.algrithm.newCode.base.b04;

import com.smida.algrithm.newCode.TreeNode;

/**
 * 二叉树前中后序遍历
 * 递归见代码
 *
 * 非递归
 * 先序：1入栈，2出栈打印，3右左子树非空入栈 循环23
 * 中序：用栈，1栈不空或当前不空进循环 2当前不空当前入栈，当前指向左子树；当前为空时令当前指向出栈元素，打印，当前指向右子树
 * 后序：俩栈，1头入栈一，2出栈一，3左右孩子非空陆续入栈一，4栈一出栈马上入栈二，23循环，最后批量打印栈2
 * 代码见：com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem.Problem_01_PreInPosTravel
 *
 *
 * @author YYF
 * @date 2022/9/14 14:41.
 */
public class P4TreeRecur {
    //前中后递归遍历 递归
    public static void printTreeRecur(TreeNode head) {
        preRecur(head);
        midRecur(head);
        postRecur(head);
    }

    private static void preRecur(TreeNode head) {
        if (null == head){
            return;
        }
        System.out.print(head.value+" ");
        preRecur(head.left);
        preRecur(head.right);
    }
    private static void midRecur(TreeNode head) {
        if (null == head){
            return;
        }
        midRecur(head.left);
        System.out.print(head.value+" ");
        midRecur(head.right);
    }
    private static void postRecur(TreeNode head) {
        if (null == head){
            return;
        }
        postRecur(head.left);
        postRecur(head.right);
        System.out.print(head.value + " ");
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

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        midRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        postRecur(head);
        System.out.println();

//        // unrecursive
//        System.out.println("============unrecursive=============");
//        preOrderUnRecur(head);
//        inOrderUnRecur(head);
//        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);

    }
}
