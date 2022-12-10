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
class Solution543 {
    //所有节点的 左右子树深度相加最大值
    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return res;
    }

    int res = 0;
    private int deep(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int lh = deep(root.left);
        int rh = deep(root.right);
        res = Math.max(res, lh + rh);
        return Math.max(lh, rh) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
