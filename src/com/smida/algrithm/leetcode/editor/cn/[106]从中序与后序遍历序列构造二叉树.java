package com.smida.algrithm.leetcode.editor.cn;

import com.smida.algrithm.newCode.TreeNode;

import java.util.HashMap;
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
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return inPosToTreeMy(inorder, postorder);
    }

    public TreeNode inPosToTreeMy(int[] in, int[] pos) {
        if (null == pos || null == in || pos.length < 1 || in.length < 1 || pos.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return inPosMy(pos, 0, pos.length - 1, in, 0, in.length - 1, map);
    }

    private TreeNode inPosMy(int[] pos, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode head = new TreeNode(pos[pe]);
        int i = map.get(pos[pe]);
        head.left = inPosMy(pos, ps, ps + i - is - 1, in, is, i - 1, map);
        head.right = inPosMy(pos, ps + i - is, pe - 1, in, i + 1, ie, map);
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
