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
class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return sub(nums, 0, nums.length - 1);
    }

    //分治
    private TreeNode sub(int[] nums, int l, int r) {
        if (l > r || l < 0 || r > nums.length - 1) {
            return null;
        } else if (l == r) {
            return new TreeNode(nums[l]);
        }
        int maxInd = l;
        for (int i = l; i <= r; i++) {
            maxInd = nums[maxInd] < nums[i] ? i : maxInd;
        }

        TreeNode node = new TreeNode(nums[maxInd]);
        TreeNode left = sub(nums, l, maxInd - 1);
        TreeNode right = sub(nums, maxInd + 1, r);
        node.left = left;
        node.right = right;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
