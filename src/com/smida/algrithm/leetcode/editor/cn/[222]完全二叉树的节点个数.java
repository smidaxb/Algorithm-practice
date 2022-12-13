package com.smida.algrithm.leetcode.editor.cn;

import com.smida.algrithm.newCode.TreeNode;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDeep = 0;
        int rDeep = 0;
        TreeNode n = root;
        while (n != null) {
            lDeep++;
            n = n.left;
        }
        while (n != null) {
            rDeep++;
            n = n.right;
        }
        if (lDeep == rDeep) {
            return (int) Math.pow(2, lDeep - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //普通二叉树计算
    public int countNodesNormal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesNormal(root.left) + countNodesNormal(root.right);
    }

    //满二叉树计算
    public int countNodesPerfect(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deep = 0;
        while (root != null) {
            deep++;
            root = root.right;
        }
        return (int) Math.pow(2, deep - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
