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
class Solution230 {
    //中序遍历找就完了
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        sub(root);
        return res;
    }

    int count;
    Integer res;

    private void sub(TreeNode root) {
        if (root == null) {
            return;
        }
        sub(root.left);
        if (count == 1) {
            res = root.val;
        }
        count--;
        if (res != null) {
            return;
        }
        sub(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
