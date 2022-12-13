package com.smida.algrithm.leetcode.editor.cn;

import com.smida.algrithm.newCode.TreeNode;

import javax.swing.*;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution538 {
    //中序遍历是递增，倒着中序遍历就是递减，同时累加即可得到累加数
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode copyTree = copyTree(root);
        return reverseInOrder(copyTree);
    }

    int sum = 0;
    private TreeNode reverseInOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverseInOrder(root.right);
        sum+= root.val;
        root.val = sum;
        reverseInOrder(root.left);
        return root;
    }

    private TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cRoot = new TreeNode(root.val);
        cRoot.left = copyTree(root.left);
        cRoot.right = copyTree(root.right);
        return cRoot;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
