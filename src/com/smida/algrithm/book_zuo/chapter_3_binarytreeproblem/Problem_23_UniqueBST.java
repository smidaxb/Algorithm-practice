package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

import java.util.List;
import java.util.LinkedList;

/**
 * 计算中序遍历为1~N的二叉树共有多少种
 * 当N<1时，返回1
 * <p>
 * 解析：
 * num(0)=1
 * num(1)=1
 * num(2)= num(1)+num(1)
 * num(3)=num(2)+num(1)*num(1)+num(2)
 * num(N)=num(0)*1*num(n-1)+num(1)*1*num(n-2)+...+num(i-1)*1*num(N-i)...
 */
public class Problem_23_UniqueBST {

    //My
    public static int numTreesMy(int n) {
        if (n < 2) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                res[i] += res[j - 1] * res[i - j];
            }
        }
        return res[n];
    }

    //标准
    public static int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
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
        String val = to + head.value + to;
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
        int n = 4;
        System.out.println(numTrees(n));
        System.out.println(numTreesMy(n));
    }

}
