package com.smida.algrithm.leetcode.editor.cn;import com.smida.algrithm.newCode.TreeNode;
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
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        return invertTree1(root);
//        return invertTree2(root);
    }
    //分治
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = invertTree1(root.left);
        TreeNode r = invertTree1(root.right);

        root.right = l;
        root.left = r;
        return root;
    }
    //遍历
    public TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree2(root.left);
        invertTree2(root.right);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
