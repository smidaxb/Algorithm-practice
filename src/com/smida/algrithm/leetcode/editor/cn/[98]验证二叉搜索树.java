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
class Solution98 {
    //中序遍历记录上一个和这一个，不能有降序
    Integer pre = null;
    int cur;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean lb = isValidBST(root.left);
        if (null != pre && pre >= root.val) {
            return false;
        }
        pre = root.val;
        boolean rb = isValidBST(root.right);
        return lb && rb;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
