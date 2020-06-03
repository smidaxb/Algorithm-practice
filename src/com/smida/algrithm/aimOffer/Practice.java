package com.smida.algrithm.aimOffer;

import java.util.*;

/**
 * @author Created by YangYifan on 2020/6/2.
 */
public class Practice {
    /**
     * 3.从尾到头打印链表
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //常规写法
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (null != listNode) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public ArrayList<Integer> printListFromTailToHeadRecursion(ListNode listNode) {
        //递归写法,思路：找到最后一个后add，再add本节点
        ArrayList<Integer> res = new ArrayList<>();
        if (null == listNode) {
            return res;
        }
        if (null != listNode.next) {
            printListFromTailToHeadRecursionSub(res, listNode.next);
        }
        res.add(listNode.val);
        return res;
    }

    private void printListFromTailToHeadRecursionSub(ArrayList<Integer> res, ListNode listNode) {
        if (null != listNode.next) {
            printListFromTailToHeadRecursionSub(res, listNode.next);
        }
        res.add(listNode.val);
    }

    /**
     * 4.重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (null == pre || 0 == pre.length) {
            return null;
        }
        int preStart = 0, inStart = 0;
        int preEnd = pre.length - 1, inEnd = preEnd;
        return reConstructBinaryTree(pre, preStart, preEnd, in, inStart, inEnd);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        int inMid = 0;
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        if (preStart > preEnd) {
            return null;
        }
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                inMid = i;
                break;
            }
        }
        int nextPreEnd = preStart + 1 + (inMid - inStart - 1);
        TreeNode root = new TreeNode(in[inMid]);
        root.left = reConstructBinaryTree(pre, preStart + 1, nextPreEnd, in, inStart, inMid - 1);
        root.right = reConstructBinaryTree(pre, nextPreEnd + 1, preEnd, in, inMid + 1, inEnd);
        return root;
    }

    /**
     * 11.输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    public int NumberOf1(int n) {
        int res = 0;
        while (0 != n) {
            if ((n & 1) == 1) {
                res += 1;
            }
            n = n >>> 1;
        }
        return res;
    }

    /**
     * 13.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 思路：插入排序
     */
    public void reOrderArray(int[] array) {
        if (null == array || array.length <= 1) {
            return;
        }
        int start = 0;
        int oddInd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                oddInd = i;
            } else {
                continue;
            }
            while (oddInd > start) {
                int tem = array[oddInd];
                array[oddInd] = array[oddInd - 1];
                array[oddInd - 1] = tem;
                oddInd--;
            }
            start++;
        }
    }

    /**
     * 14.输入一个链表，输出该链表中倒数第k个结点。
     * 思路：直接跑遍整个链表，算出总节点数，然后直接走
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (null == head || k < 1) {
            return null;
        }
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        if (k > length) {
            return null;
        }
        ListNode res = head;
        for (int i = 0; i < length - k; i++) {
            res = res.next;
        }
        return res;
    }

    /**
     * 19.顺时针打印矩阵
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            //从左到右
            for (int i = left; i <= right; i++) {
                arr.add(matrix[top][i]);
            }
            //从上到下
            for (int i = top + 1; i <= bottom; i++) {
                arr.add(matrix[i][right]);
            }
            //从右到左，判断一行情况
            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    arr.add(matrix[bottom][i]);
                }
            }
            //从下到上，判断一列情况
            if (left != right) {
                for (int i = bottom - 1; i >= top + 1; i--) {
                    arr.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return arr;
    }

    /**
     * 22.二叉树层次遍历
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList res = new ArrayList();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            res.add(node.val);
            if (null != node.left) {
                que.offer(node.left);
            }
            if (null != node.right) {
                que.offer(node.right);
            }
        }
        return res;
    }

    /**
     * 23.判断数组是否是二叉查找树遍历的结果
     * 思路：bst最后一个节点必为跟，左树节点小于跟，又树节点大于跟，递归
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (null == sequence || 0 == sequence.length) {
            return false;
        }
        return judgeBST(sequence, 0, sequence.length - 1);
    }

    private boolean judgeBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        Integer leftEnd = start;
        for (int i = start; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
            leftEnd = i;
        }
        for (int i = leftEnd+1; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return judgeBST(sequence, start, leftEnd) && judgeBST(sequence, leftEnd + 1, end - 1);
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
