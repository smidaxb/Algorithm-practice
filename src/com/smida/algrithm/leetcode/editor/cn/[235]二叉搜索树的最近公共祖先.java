package com.smida.algrithm.leetcode.editor.cn;import com.smida.algrithm.newCode.TreeNode;
//leetcode submit region begin(Prohibit modification and deletion)



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution265 {
    private int small;
    private int big;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        small = Math.min(p.val, q.val);
        big = Math.max(p.val, q.val);

        if (root.val > big) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < small) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
