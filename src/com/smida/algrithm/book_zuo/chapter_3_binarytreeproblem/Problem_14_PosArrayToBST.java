package com.smida.algrithm.book_zuo.chapter_3_binarytreeproblem;

import com.smida.algrithm.newCode.TreeNode;

/**
 * 判断一个数组是否是搜索二叉树的后序遍历
 * 已知一个搜索二叉树的后序遍历，生成二叉树
 */
public class Problem_14_PosArrayToBST {
    //标准答案
    public static boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    public static boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1) {
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }


    public static TreeNode posArrayToBST(int[] posArr) {
        if (posArr == null) {
            return null;
        }
        return posToBST(posArr, 0, posArr.length - 1);
    }

    public static TreeNode posToBST(int[] posArr, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode head = new TreeNode(posArr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (posArr[end] > posArr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        head.left = posToBST(posArr, start, less);
        head.right = posToBST(posArr, more, end - 1);
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

    //My 若为二叉排序树则数组尾部为头结点，前半部分小于头结点，后半部分大于头结点
    public static boolean isPostArrayMy(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPartBSTPost(arr, 0, arr.length - 1);
    }

    private static boolean isPartBSTPost(int[] arr, int start, int end) {
        if (start < 0 || end < 0 || start >= end) {
            return true;
        }
        int lastVal = arr[end];
        int preStart = start;
        int preEnd;
        //确保遍历时第一个大于end的下标能被记录
        int posStart = end;
        int posEnd = end - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] > lastVal && posStart == -1) {
                posStart = i;
            }
            if (arr[i] < lastVal && i > posStart) {
                return false;
            }
        }
        preEnd = posStart - 1;
        return isPartBSTPost(arr, preStart, preEnd) && isPartBSTPost(arr, posStart, posEnd);
    }

    public static TreeNode posArrayToBSTMy(int[] posArr) {
        if (posArr == null) {
            return null;
        }
        return posToBSTMy(posArr, 0, posArr.length - 1);
    }

    private static TreeNode posToBSTMy(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
		if (start == end) {
			return new TreeNode(arr[start]);
		}
        TreeNode head = new TreeNode(arr[end]);
        int lastVal = arr[end];
        int preStart = start;
        int preEnd;
        //确保遍历时第一个大于end的下标能被记录
        int posStart = end;
        int posEnd = end - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] > lastVal) {
                posStart = i;
                break;
            }
        }
        preEnd = posStart - 1;
        head.left = posToBSTMy(arr, preStart, preEnd);
        head.right = posToBSTMy(arr, posStart, posEnd);
        return head;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 6, 5, 7, 4};
//        int[] arr = {2, 4};
        int[] arr = {5, 4};
//        int[] arr = {2};
        System.out.println(isPostArray(arr));
        System.out.println(isPostArrayMy(arr));
        printTree(posArrayToBST(arr));
        printTree(posArrayToBSTMy(arr));
    }

}
