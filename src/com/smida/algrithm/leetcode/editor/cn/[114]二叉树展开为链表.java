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
class Solution114 {
    //分治法，子树拉链后，root指向左边的，左边的指向右边拉链的结果
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        subMethod(root);
    }

    private TreeNode subMethod(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode originLeft = root.left;
        TreeNode originRight = root.right;

        subMethod(root.left);
        subMethod(root.right);

        //root右指针连向左链，左指针置空
        root.right = originLeft;
        root.left = null;

        //沿着右指针一路走到链表尾部
        TreeNode node = root;
        while (node != null && node.right != null){
            node = node.right;
        }
        //链表尾部连接右链表
        node.right = originRight;

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
