package com.smida.algrithm.leetcode.editor.cn;import com.smida.algrithm.newCode.TreeNode;

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
class Solution105 {
    public TreeNode buildTree(int[] pre, int[] in) {
        if (null == pre || null == in || pre.length < 1 || in.length < 1 || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preInMy(pre, 0, pre.length - 1,  0, in.length - 1, map);
    }

    private static TreeNode preInMy(int[] pre, int ps, int pe,  int is, int ie, HashMap<Integer, Integer> map) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode head = new TreeNode(pre[ps]);
        int i = map.get(pre[ps]);
        head.left = preInMy(pre, ps + 1, ps + i - is, is, i - 1, map);
        head.right = preInMy(pre, ps + i - is + 1, pe, i + 1, ie, map);
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
