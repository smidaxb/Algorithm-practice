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
class Solution104 {
    public int maxDepth(TreeNode root) {
//        return maxDepth1(root);
        return maxDepth2(root);
    }

    //用遍历解决
    Integer res = 0;
    Integer curDeep = 0;

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            res = Math.max(res, curDeep);
            return res;
        }
        curDeep++;
        maxDepth1(root.left);
        maxDepth1(root.right);
        curDeep--;
        return res;
    }

    //拆分为左右子树的问题
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = maxDepth2(root.left);
        int rh = maxDepth2(root.right);
        return Math.max(lh, rh) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
