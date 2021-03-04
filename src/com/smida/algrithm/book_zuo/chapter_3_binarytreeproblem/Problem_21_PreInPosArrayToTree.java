package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

import java.util.HashMap;

/**
 * 前中、中后序遍历重构二叉树
 */
public class Problem_21_PreInPosArrayToTree {

    //标准答案
    public static TreeNode preInToTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    public static TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj,
                                 HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }
        TreeNode head = new TreeNode(p[pi]);
        int index = map.get(p[pi]);
        head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
        head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
        return head;
    }

    public static TreeNode inPosToTree(int[] in, int[] pos) {
        if (in == null || pos == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return inPos(in, 0, in.length - 1, pos, 0, pos.length - 1, map);
    }

    public static TreeNode inPos(int[] n, int ni, int nj, int[] s, int si, int sj,
                                 HashMap<Integer, Integer> map) {
        if (si > sj) {
            return null;
        }
        TreeNode head = new TreeNode(s[sj]);
        int index = map.get(s[sj]);
        head.left = inPos(n, ni, index - 1, s, si, si + index - ni - 1, map);
        head.right = inPos(n, index + 1, nj, s, si + index - ni, sj - 1, map);
        return head;
    }

    //My
    public static TreeNode preInToTreeMy(int[] pre, int[] in) {
        if (null == pre || null == in || pre.length < 1 || in.length < 1 || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preInMy(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private static TreeNode preInMy(int[] pre, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode head = new TreeNode(pre[ps]);
        int i = map.get(pre[ps]);
        head.left = preInMy(pre, ps + 1, ps + i - is, in, is, i - 1, map);
        head.right = preInMy(pre, ps + i - is + 1, pe, in, i + 1, ie, map);
        return head;
    }

    public static TreeNode inPosToTreeMy(int[] in, int[] pos) {
        if (null == pos || null == in || pos.length < 1 || in.length < 1 || pos.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return inPosMy(pos, 0, pos.length - 1, in, 0, in.length - 1, map);
    }

    private static TreeNode inPosMy(int[] pos, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode head = new TreeNode(pos[pe]);
        int i = map.get(pos[pe]);
        head.left = inPosMy(pos, ps, ps + i - is - 1, in, is, i - 1, map);
        head.right = inPosMy(pos, ps + i - is, pe - 1, in, i + 1, ie, map);
        return head;
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
        int[] pre = {1, 2, 4, 5, 8, 9, 3, 6, 7};
        int[] in = {4, 2, 8, 5, 9, 1, 6, 3, 7};
        int[] pos = {4, 8, 9, 5, 2, 6, 7, 3, 1};
        printTree(preInToTree(pre, in));
        printTree(preInToTreeMy(pre, in));
        printTree(inPosToTree(in, pos));
        printTree(inPosToTreeMy(in, pos));
    }

}
