package com.smida.algrithm.leetcode.editor.cn;

import com.smida.algrithm.newCode.TreeNode;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution236 {
    //此题假设了root中肯定包含pq
    //找最近公共父节点可以理解为先序找一个节点，其为q或q，or 左子树或右子树里接着找
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        //前提是root下必包含 p 或 q，则找到了可直接返回(其实n个节点的公共父节点也一模一样)
        if (root.equals(p) || root.equals(q)) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (null != l && null != r) {
            return root;
        }
        return null == l ? r : l;
    }

    //当不一定包含pq时
    //find函数还是找是否包含p或q的函数，不过采用后续遍历
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find(root, p, q);
        if (findP && findQ) {
            return res;
        }
        return null;
    }

    private boolean findP = false;
    private boolean findQ = false;

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (null != l && null != r) {
            return root;
        }

        if (root.equals(p) || root.equals(q)) {
            if (root.equals(p)) findP = true;
            if (root.equals(q)) findQ = true;
            return root;
        }

        return l == null ? r : l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
