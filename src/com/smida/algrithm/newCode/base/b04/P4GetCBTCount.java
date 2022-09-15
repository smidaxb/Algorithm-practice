package com.smida.algrithm.newCode.base.b04;

import com.smida.algrithm.newCode.TreeNode;

/**
 * 已知完全二叉树，求节点个数
 * 要求时间复杂度低于N
 * 等于n可以遍历
 * 思路：遍历左边界，求高度h；
 * 右边要跟总一般深，则左树是满的，公式求，再求右数
 * 右边少一层，则右树是满的，公式求，再求左树
 *
 * @author YYF
 * @date 2022/9/14 20:07.
 */
public class P4GetCBTCount {

    public static int TreeNodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * @param node 当前节点
     * @param level 当前节点在第几层
     * @param h 整棵树的深度
     * @return 当前节点为头的完全二叉树的节点个数
     */
    public static int bs(TreeNode node, int level, int h) {
        if (level == h) {
            return 1;
        }
        //右树深h，左树满
        if (mostLeftLevel(node.right, level + 1) == h) {
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            //右树深h-1，右树满
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    //求树深
    public static int mostLeftLevel(TreeNode TreeNode, int level) {
        while (TreeNode != null) {
            level++;
            TreeNode = TreeNode.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        System.out.println(TreeNodeNum(head));

    }
}
